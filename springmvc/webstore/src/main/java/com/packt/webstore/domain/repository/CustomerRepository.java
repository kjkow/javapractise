package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Customer;

import java.util.List;

/**
 * Created by kamil on 2017-09-04.
 */

public interface CustomerRepository {

    List<Customer> getAllCustomers();
}
