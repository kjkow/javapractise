package com.packt.webstore.controller;

import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

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
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}

	@RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
	public String getProductByType( //todo: why was it getProductById? should it be 'type'?
			@PathVariable("type") String productType,
			Model model
	) {
		model.addAttribute("products", productService.getProductById(productType));
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
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}


}
