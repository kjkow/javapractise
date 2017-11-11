package com.packt.webstore.controller;

import com.packt.webstore.domain.AvailableProductSearchCriteria;
import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discounted");
	} //somebody could manipulate http request and add fields that we don't want at this point in our domain object

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory){
		model.addAttribute("products", productService.getProductsByAttribute(AvailableProductSearchCriteria.CATEGORY, productCategory));
		return "products";
	}

	@RequestMapping("/filter/{byCriteria}")
	public String getProductsByFilter(
			@MatrixVariable(pathVar = "byCriteria")
			Map<String, List<String>> filterParameters,
			Model model
			){
		model.addAttribute("products", productService.getProductsByFilter(filterParameters));
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(
			@RequestParam("id") String productId,
			Model model
	){
		List<Product> products = productService.getProductsByAttribute(AvailableProductSearchCriteria.ID, productId);
		if(products.size() > 0){
			model.addAttribute("product", products.get(0));
			return "product";
		}
		return "redirect:/products";
	}

	@RequestMapping(value ="/{category}/{price}", method = RequestMethod.GET)
	public String filterProducts(
			Model model,
			@PathVariable("category") String productCategory,
			@MatrixVariable(pathVar = "price") Map<String, String> filterParameters,
			@RequestParam("manufacturer") String manufacturer){

		Set<Product> searchResults = new HashSet<>();
		//todo: can't just put them in one bag, use SearchCriteria and handle this in services
		searchResults.addAll(productService.getProductsByPriceFilter(filterParameters));
		searchResults.addAll(productService.getProductsByAttribute(AvailableProductSearchCriteria.CATEGORY, productCategory));
		searchResults.addAll(productService.getProductsByAttribute(AvailableProductSearchCriteria.MANUFACTURER, manufacturer));

		model.addAttribute("products", searchResults);
		return "products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(
			@ModelAttribute("newProduct") Product newProduct,
			BindingResult result){

		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0){
			throw new RuntimeException("Unauthorized fields binding attempt");
		}

		productService.addProduct(newProduct);
		return "redirect:/products";
	}

}
