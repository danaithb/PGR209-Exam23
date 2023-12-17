package com.example.pgr209exam23.components;

import com.example.pgr209exam23.model.Address;
import com.example.pgr209exam23.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AddressServiceIntegrationTest {

    @Autowired
    private AddressService addressService;
    @Test
    @Transactional
    void shouldUpdateAddress() {
        Address newAddress = new Address("Urtegata", "Oslo", "6666");
        Address savedAddress = addressService.createAddress(newAddress);

        savedAddress.setCity("Kirkegata");
        Address updatedAddress = addressService.updateAddress(savedAddress);

        assert updatedAddress != null;
        assert "Kirkegata".equals(updatedAddress.getCity());

    }
}