package com.brujula.infraestructure.api.mappers;

import com.brujula.domain.Customer;
import com.brujula.infraestructure.api.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerDtoMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);

}
