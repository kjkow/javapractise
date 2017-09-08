package com.packt.webstore.service;

import com.packt.webstore.domain.Customer;

import java.util.List;

/**
 * Created by kamil on 2017-09-04.
 */
public interface CustomerService {

    List<Customer> getAllCustomers();
}
