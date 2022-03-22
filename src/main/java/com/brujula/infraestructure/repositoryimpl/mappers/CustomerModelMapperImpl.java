package com.brujula.infraestructure.repositoryimpl.mappers;

import com.brujula.domain.Customer;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelMapperImpl implements CustomerModelMapper {
    @Override
    public Customer customerModelToCustomer(CustomerModel customerModel) {
        return Customer.createCustomer(
                customerModel.getId(),
                customerModel.getFirstName(),
                customerModel.getLastName(),
                customerModel.getCompany());
    }

    @Override
    public CustomerModel customerToCustomerModel(Customer customer) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customer.getId());
        customerModel.setFirstName(customer.getFirstName());
        customerModel.setLastName(customer.getLastName());
        customerModel.setCompany(customer.getCompany());
        return customerModel;
    }

}
