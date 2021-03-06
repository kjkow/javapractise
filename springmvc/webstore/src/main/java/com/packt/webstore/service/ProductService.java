package com.packt.webstore.service;

import com.packt.webstore.domain.AvailableProductSearchCriteria;
import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kamil on 2017-09-04.
 */
public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByAttribute(AvailableProductSearchCriteria attribute, String value);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParameters);

    List<Product> getProductsByPriceFilter(Map<String, String> priceFilter);

    void addProduct(Product product);
}