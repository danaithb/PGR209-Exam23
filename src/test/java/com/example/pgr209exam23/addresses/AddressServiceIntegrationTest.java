
package com.example.pgr209exam23.addresses;

import com.example.pgr209exam23.model.Address;
import com.example.pgr209exam23.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

//Represents an integration test for the AddressService. Uses the Spring Boot testing framework.
//Annotated with @SpringBootTest.

@SpringBootTest
public class AddressServiceIntegrationTest {

    @Autowired
    private AddressService addressService;
    @Test
    @Transactional
    void shouldUpdateAddress() {
        //here we create a new address and saves it.
        Address newAddress = new Address("Urtegata", "Oslo", "6666");
        Address savedAddress = addressService.createAddress(newAddress);

        //then we modify the city and updates it.
        savedAddress.setCity("Kirkegata");
        Address updatedAddress = addressService.updateAddress(savedAddress);

        //lastly we verify the update
        assert updatedAddress != null;
        assert "Kirkegata".equals(updatedAddress.getCity());

    }
}