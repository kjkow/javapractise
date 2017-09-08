package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;

import java.util.List;

/**
 * Created by kamil on 2017-08-30.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductByCategory(String category);
}
