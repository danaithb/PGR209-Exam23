package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Customer;
import com.example.pgr209exam23.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//Sources: ownerService vet clinic example, and lecture 16
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
    public Page<Customer> getAllCustomers(int page, int size){
        return customerRepo.findAll(PageRequest.of(page, size));
    }

    //Delete one
    public void deleteCustomerById(Long id){
        customerRepo.deleteById(id);
    }

    //update one
    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }

}
