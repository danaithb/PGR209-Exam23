package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Address;
import com.example.pgr209exam23.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    // Get one by id
    public Address getAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }

     // Delete one
    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);}

    // Get all with pagination
    public Page<Address> getAllAddresses(int page, int size) {
        return addressRepo.findAll(PageRequest.of(page, size));
    }

    // Update one
    public Address updateAddress(Address address) {
        return addressRepo.save(address);
    }

    // Create one
    public Address createAddress(Address address) {
        return addressRepo.save(address);
    }
}
