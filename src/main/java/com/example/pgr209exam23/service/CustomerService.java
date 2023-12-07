package com.example.pgr209exam23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


//kilde ownerService vet clinic example
@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    //create one
    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    //Get one by id
    public Customer findCustomerById(Long id){
        return customerRepo.findById(id).orElse(null);
    }

    //Get all with pagination
    public Page<Customer> getCustomers(int page, int size){
        return customerRepo.findAll(PageRequest.of(page, size));
    }

    //Delete one
    public void deleteCustomerById(Long id){
        customerRepo.deleteById(id);
    }


}


/*
MAngler:
	- Update one
*/