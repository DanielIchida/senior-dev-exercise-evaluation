package com.brujula.infraestructure.api.mappers;

import com.brujula.domain.Customer;
import com.brujula.infraestructure.api.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoMapperImpl implements CustomerDtoMapper{
    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        return Customer.createCustomer(0,
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getCompany());
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        return CustomerDto.createCustomerDto(customer);
    }
}
