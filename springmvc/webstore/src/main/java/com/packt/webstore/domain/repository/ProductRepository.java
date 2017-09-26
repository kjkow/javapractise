package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kamil on 2017-08-30.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParameters);

    List<Product> getProductsByManufacturer(String manufacturer);
}
