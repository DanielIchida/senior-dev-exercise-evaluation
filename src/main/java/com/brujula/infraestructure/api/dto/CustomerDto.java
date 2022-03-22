package com.brujula.infraestructure.api.dto;

import com.brujula.domain.Customer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 50, message
            = "firstName must be between 10 and 50 characters")
    private String firstName;

    @Size(min = 10, max = 100, message
            = "lastname must be between 10 and 100 characters")
    private String lastName;

    @NotNull(message = "company can't be null")
    @NotEmpty
    private String company;

    public static CustomerDto createCustomerDto(Customer customer){
        return new CustomerDto(customer.getFirstName(), customer.getLastName(), customer.getCompany());
    }

    private CustomerDto(String firstName, String lastName, String company) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCompany(company);
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setCompany(String company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
