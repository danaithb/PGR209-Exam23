package com.example.pgr209exam23.components;
import com.example.pgr209exam23.service.PartService;
import com.example.pgr209exam23.model.Part;
import com.example.pgr209exam23.repo.PartRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

@SpringBootTest
public class PartServiceUnitTest {

    @MockBean
    private PartRepo partRepo;

    @Autowired
    private PartService partService;

    @Test
    void shouldCreatePart(){
        Part part = new Part("New Part");
        when(partRepo.save(any(Part.class))).thenReturn(part);

        Part createdPart = partService.createPart(part);

        assert "New Part".equals(createdPart.getPartName());
    }

    @Test
    void shouldFindPartById(){
        Long partId = 1L;
        Part part = new Part("Existing Part");
        part.setPartId(partId);
        when(partRepo.findById(partId)).thenReturn(Optional.of(part));

        Part foundPart = partService.findPartById(partId);

        assert foundPart != null;
        assert partId.equals(foundPart.getPartId());
    }

    @Test
    void shouldDeletePartById(){
        Long partId = 1L;
        partService.deletePartById(partId);
    }
}
