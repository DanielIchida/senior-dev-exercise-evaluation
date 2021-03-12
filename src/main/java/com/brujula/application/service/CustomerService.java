package com.brujula.application.service;

import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer get(int id) {
        return repository.getCustomer(id);
    }
}
