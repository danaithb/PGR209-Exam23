package com.example.pgr209exam23.addresses;

import com.example.pgr209exam23.model.Address;
import com.example.pgr209exam23.repo.AddressRepo;
import com.example.pgr209exam23.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;

//A unit test for the AddressService. Uses the Spring Boot testing framework and is annotated
//with @SpringBootTest.
//A test that verifies the functionality of creating an address.

@SpringBootTest
public class AddressServiceUnitTest {

    @MockBean
    private AddressRepo addressRepo;

    @Autowired
    private AddressService addressService;

    @Test
    void shouldCreateAddress() {
        //here we create a new address
        Address newAddress = new Address("Blåveien", "Oslo", "6666");

        //here we mock the behavior of the repo to return the new address
        when(addressRepo.save(any(Address.class))).thenReturn(newAddress);

        //here we call the createAddress and assert properties to address.
        Address createdAddress = addressService.createAddress(newAddress);

        assert "Blåveien".equals(createdAddress.getStreet());
        assert "Oslo".equals(createdAddress.getCity());
        assert "6666".equals(createdAddress.getZipCode());

    }
}