package com.example.pgr209exam23.components;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//måtte bruke MockMvcRequestBuilders her, funket ikke med get og delete
@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerEndToEndTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void shouldDeleteAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/address/{id}", 1))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/address/{id}", 1))
                .andExpect(status().isNotFound());

    }

}
