package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	private List<Product> listOfProducts = new ArrayList<>();
	
	public InMemoryProductRepository() {
		Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 640x1136 i 8-megapikselowym aparatem");
		iphone.setCategory("smartfon");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);

		Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorami Intel Core 3. generacji");
		laptop_dell.setCategory("laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);

		Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon S4 Pro");
		tablet_Nexus.setCategory("tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);

		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);

	}

	@Override
	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	@Override
	public Product getProductById(String productId) {
		Product productById = null;
		
		for(Product product : listOfProducts) {
			if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
				productById = product;
				break;
			}
		}
		
		if(productById == null){
			throw new IllegalArgumentException("Brak produktu o wskazanym id: "+ productId);
		}
		
		return productById;
	}

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for(Product product: listOfProducts){
        	if(category.equalsIgnoreCase(product.getCategory())){
        		productsByCategory.add(product);
			}
		}
		return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParameters) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criteria = filterParameters.keySet();

        if(criteria.contains("brand")){
        	productsByBrand = getProductsByFilter(filterParameters.get("brand"));
		}

		if(criteria.contains("category")){
        	for(String category: filterParameters.get("category")){
        		productsByCategory.addAll(this.getProductByCategory(category));
			}
		}

		if(criteria.contains("price")){
			//todo: make filter search
		}

		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
		List<Product> productsByManufacturer = new ArrayList<>();
		for(Product product: listOfProducts){
			if(manufacturer.equalsIgnoreCase(product.getManufacturer())){
				productsByManufacturer.add(product);
			}
		}
		return productsByManufacturer;
    }

	@Override
	public List<Product> getProductsByPriceRange(Map<String, String> priceRange) {
		Set<String> range = priceRange.keySet();
		List<Product> products = new ArrayList<>();
		int lessThan = -1; //todo: those integers shouldn't be here
		int moreThan = 1;
		BigDecimal lowValue = new BigDecimal(0); //todo: should it be this way? with zero?
		BigDecimal highValue = new BigDecimal(0);

		if(range.contains("low")){ //todo: dry_1
			lowValue = new BigDecimal(priceRange.get("low"));
		}
		if(range.contains("high")){
			highValue = new BigDecimal(priceRange.get("high"));
		}


		if(priceRange.size() == 1){
			if(range.contains("low")) { //todo: dry_2
				products.addAll(getProductsByRange(lowValue, moreThan));
			}
			if(range.contains("high")){
				products.addAll(getProductsByRange(highValue, lessThan));
			}
		}else {
			for(Product product: listOfProducts){
				if(product.getUnitPrice().compareTo(lowValue) == moreThan &&
						product.getUnitPrice().compareTo(highValue) == lessThan){
					products.add(product);
				}
			}
		}

		return products;
	}

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    private List<Product> getProductsByRange(BigDecimal value, int comparator){
		List<Product> products = new ArrayList<>();

		for(Product product: listOfProducts){
			if(product.getUnitPrice().compareTo(value) == comparator){
				products.add(product);
			}
		}

		return products;
	}

	private Set<Product> getProductsByFilter(List<String> filterValues){ //TODO: unscalable, compares only product.getManufacturer()
		Set<Product> searchResults = new HashSet<>();
		for(String filterValue: filterValues){
			setProductsByFilterName(filterValue, searchResults);
		}
		return searchResults;
	}

	private void setProductsByFilterName(String filterValue, Set<Product> productSet){
		for(Product product: listOfProducts){
			if(isManufacturerMatched(filterValue, product)){//todo: maybe enum with values that can be filtered, and here switch construction
				productSet.add(product);
			}
		}
	}

	private boolean isManufacturerMatched(String filterValue, Product product){
		return filterValue.equalsIgnoreCase(product.getManufacturer());
	}
}
