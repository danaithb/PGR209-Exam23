package com.example.pgr209exam23.components;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//An end-to-end test for the MachineController.
//Uses Spring Boot testing framework with MockMvc for simulating HTTP requests.
//the test verifies the functionality of fetching all machines from the "/api/machine".

@SpringBootTest
@AutoConfigureMockMvc
public class MachineControllerEndToEndTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFetchAllMachines() throws Exception {
        mockMvc.perform(get("/api/machine"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

}
