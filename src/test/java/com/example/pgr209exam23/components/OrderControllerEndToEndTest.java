package com.example.pgr209exam23.components;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerEndToEndTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFetchAllOrders() throws Exception{
        mockMvc.perform(get("/api/order"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void shouldDeleteOrderById() throws Exception{
        mockMvc.perform(get("/api/order/id"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
