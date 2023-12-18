package com.example.pgr209exam23.components;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//An end-to-end test for the AddressController.
//Uses Spring Boot testing framework with MockMvc to simulate HTTP requests.

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerEndToEndTest {

    @Autowired
    private MockMvc mockMvc;

//Uses get request to fetch an address by id, and write the expected outcome.
    @Test
    void shouldFetchAddressById() throws Exception {
        mockMvc.perform(get("/api/address/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}