package com.packt.webstore.service;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kamil on 2017-09-04.
 */
public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductById(String id);//todo: reorganize jsp to read single Product object

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParameters);
}