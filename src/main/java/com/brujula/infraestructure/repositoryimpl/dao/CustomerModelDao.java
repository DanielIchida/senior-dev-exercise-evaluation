package com.brujula.infraestructure.repositoryimpl.dao;


import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerModelDao extends JpaRepository<CustomerModel,Integer> {
}
