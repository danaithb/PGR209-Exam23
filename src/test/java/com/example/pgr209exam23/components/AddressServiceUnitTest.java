package com.example.pgr209exam23.components;

import com.example.pgr209exam23.model.Address;
import com.example.pgr209exam23.repo.AddressRepo;
import com.example.pgr209exam23.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AddressServiceUnitTest {

    @MockBean
    private AddressRepo addressRepo;

    @Autowired
    private AddressService addressService;

    @Test
    void shouldCreateAddress() {
        Address newAddress = new Address("street", "City", "6666");
        when(addressRepo.save(any(Address.class))).thenReturn(newAddress);

        Address createdAddress = addressService.createAddress(newAddress);

        assert "street".equals(createdAddress.getStreet());
        assert "City".equals(createdAddress.getCity());
        assert "6666".equals(createdAddress.getZipCode());

    }


}
