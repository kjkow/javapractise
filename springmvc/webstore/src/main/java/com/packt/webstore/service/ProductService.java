package com.packt.webstore.service;

import com.packt.webstore.domain.Product;

import java.util.List;

/**
 * Created by kamil on 2017-09-04.
 */
public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductById(String id);//tesotowo jest to lista bo tak mam już skonstruowany jsp
}