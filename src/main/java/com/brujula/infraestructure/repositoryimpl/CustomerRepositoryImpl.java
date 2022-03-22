package com.brujula.infraestructure.repositoryimpl;

import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;
import com.brujula.infraestructure.repositoryimpl.dao.CustomerModelDao;
import com.brujula.infraestructure.repositoryimpl.mappers.CustomerModelMapperImpl;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerModelDao customerModelDao;
    private final CustomerModelMapperImpl customerModelMapper;

    @Autowired
    public CustomerRepositoryImpl(CustomerModelDao customerModelDao, CustomerModelMapperImpl customerModelMapper) {
        this.customerModelDao = customerModelDao;
        this.customerModelMapper = customerModelMapper;
    }

    @Override
    public Customer getCustomer(int id) {
        Optional<CustomerModel> findById = customerModelDao.findById(id);
        return findById.map(customerModelMapper::customerModelToCustomer).orElse(null);

    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerModel model = new CustomerModelMapperImpl().customerToCustomerModel(customer);
        return customerModelMapper.customerModelToCustomer(customerModelDao.save(model));
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        Optional<CustomerModel> findById = customerModelDao.findById(id);
        if(findById.isPresent()){
            CustomerModel find = findById.get();
            find.setFirstName(customer.getFirstName());
            find.setLastName(customer.getLastName());
            find.setCompany(customer.getCompany());
            return customerModelMapper.customerModelToCustomer(customerModelDao.save(find));
        }else{
            return null;
        }
    }
}
