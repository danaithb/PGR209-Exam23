
package com.example.pgr209exam23.components;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//End-to-end tests for the PartController using MockMvc.
//Tests for fetching a part by ID, and deleting a part by id.

@SpringBootTest
@AutoConfigureMockMvc
public class PartControllerEndToEndTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void shouldFetchPartById() throws Exception {
        mockMvc.perform(get("/api/part/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"partId\":1,\"partName\":\"Girkasse Del 1\"}"));
    }

    //må sjekke opp i noe før jeg kan fikse denne
    /*@Test
    void shouldDeletePartById() throws Exception {
        mockMvc.perform(delete("/api/part/{id}", 1))
                .andExpect(status().isNoContent());
    }*/

}
