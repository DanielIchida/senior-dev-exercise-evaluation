package com.brujula.infraestructure.api;

import com.brujula.application.service.CustomerService;
import com.brujula.infraestructure.api.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody CustomerDto get(@PathVariable int id) {
        return CustomerDto.createCustomerDto(customerService.get(id));
    }
}
