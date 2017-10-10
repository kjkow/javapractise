package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.AvailableProductSearchCriteria;
import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kamil on 2017-08-30.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    List<Product> getProductsByAttribute(AvailableProductSearchCriteria attribute, String value);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParameters);

    List<Product> getProductsByPriceRange(Map<String, String> priceRange);

    void addProduct(Product product);
}
