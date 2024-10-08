
package com.example.pgr209exam23.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//End-to-end tests for the OrderController using MockMvc.
//tests the functionality of fetching all orders through the "/api/order" using get request.

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


}