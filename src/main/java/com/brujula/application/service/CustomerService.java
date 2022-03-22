package com.brujula.application.service;

import com.brujula.application.exception.MessageException;
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

    public Customer get(int id){
        Customer currentCustomer = repository.getCustomer(id);
        if(currentCustomer != null){
            return currentCustomer;
        }else{
           throw new MessageException("no customer found");
        }
    }

    public Customer save(Customer customer){
        return repository.saveCustomer(customer);
    }

    public Customer update(int id , Customer customer){
        Customer currentCustomer = repository.getCustomer(id);
        if(currentCustomer != null){
            return repository.updateCustomer(id,customer);
        }else{
            throw new MessageException("no update found");
        }
    }
}
