package com.example.pgr209exam23.components;
import com.example.pgr209exam23.model.Part;
import com.example.pgr209exam23.service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PartServiceIntegrationTest {

    @Autowired
    private PartService partService;

    @Test
    @Transactional
    void shouldCreateAndSavePart() {
        Part newPart = new Part("Test Part");

        Part savedPart = partService.createPart(newPart);

        assertNotNull(savedPart);
        assertNotNull(savedPart.getPartId());
        assert "Test Part".equals(savedPart.getPartName());
    }
}
