package com.brujula.infraestructure.repositoryimpl.mappers;

import com.brujula.domain.Customer;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerModelMapper {

    Customer customerModelToCustomer(CustomerModel customerModel);
    CustomerModel customerToCustomerModel(Customer customer);

}
