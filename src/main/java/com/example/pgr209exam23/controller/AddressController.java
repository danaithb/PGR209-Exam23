package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Address;
import com.example.pgr209exam23.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

//RESTful API controller class for addresses. The controller interacts with AddresseService, so it can perform operations with the
// methods we have made.
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    //Constructor for AddressController, takes parameter: addressService
    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    //Get all with pagination
    @GetMapping
    public Page<Address> getAddresses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return addressService.getAllAddresses(page, size);
    }

    //Get one by id
    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    //Create one
    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    //Delete one
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
    }

    //Update one
    @PutMapping
    public Address updateAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }

}
