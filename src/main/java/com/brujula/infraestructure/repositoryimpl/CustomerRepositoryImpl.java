package com.brujula.infraestructure.repositoryimpl;

import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer getCustomer(int id) {
        return null;
    }
}
