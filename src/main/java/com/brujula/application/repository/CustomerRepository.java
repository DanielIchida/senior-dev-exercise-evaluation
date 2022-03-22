package com.brujula.application.repository;

import com.brujula.domain.Customer;

public interface CustomerRepository {
    Customer getCustomer(int id);
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(int id,Customer customer);
}
