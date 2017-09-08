package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamil on 2017-09-04.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> allCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer john = new Customer();
        john.setName("John Doe");
        john.setCustomerId(1);
        john.setAddress("00 Washingotn Post West Av.");
        john.setNoOfOrdersMade(3);
        allCustomers.add(john);

        Customer dave = new Customer();
        dave.setName("Dave Yunn");
        dave.setCustomerId(2);
        dave.setAddress("45-11 Texas Colorado");
        dave.setNoOfOrdersMade(17);
        allCustomers.add(dave);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return allCustomers;
    }
}
