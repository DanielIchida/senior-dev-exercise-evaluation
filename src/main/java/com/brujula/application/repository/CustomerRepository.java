package com.brujula.application.repository;

import com.brujula.domain.Customer;

public interface CustomerRepository {
    Customer getCustomer(int id);
}
