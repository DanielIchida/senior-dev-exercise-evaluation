package com.brujula.domain;

public class Customer {
    
    private int id;
    private String firstName;
    private String lastName;
    private String company;
    
    public static Customer createCustomer(int id, String firstName, String lastName, String company){
        return new Customer(id, firstName, lastName, company);
    }

    private Customer(int id, String firstName, String lastName, String company) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCompany(company);
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

    private void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
}
