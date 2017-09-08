package com.packt.webstore.service;

/**
 * Created by kamil on 2017-09-04.
 */
public interface OrderService {

    void processOrder(String productId, int count);
}
