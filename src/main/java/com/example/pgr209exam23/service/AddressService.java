/*package com.example.pgr209exam23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo){
        this.addressRepo = addressRepo;
    }

    //Get one by id
    public Address getAddressById(LongId){
        return addressRepo.findById(id).orElse(null);
    }

    //Create one
    public Address createAddress(Address address){
        return addressRepo.save(address);
    }

    // Delete one
    public void deleteAddress(Long id){
        addressRepo.deleteById(id);
    }

//Get all with pagination
    public Page<Address> getAddress(int page, int size){
        return addressRepo.findAll(PageRequest.of(page, size));
    }
}



/*
MAngler:
	- Update one
*/