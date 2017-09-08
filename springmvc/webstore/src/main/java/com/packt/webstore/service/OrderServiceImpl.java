package com.packt.webstore.service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 2017-09-04.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        long actualUnitsInStock = productById.getUnitsInStock();

        if(actualUnitsInStock < count){
            throw new IllegalArgumentException("Zbyt mało towaru. Liczba sztuk w magazynie: " + actualUnitsInStock);
        }

        productById.setUnitsInStock(actualUnitsInStock - count);
    }
}
