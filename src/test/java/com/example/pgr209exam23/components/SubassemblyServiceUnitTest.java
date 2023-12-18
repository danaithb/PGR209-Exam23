package com.example.pgr209exam23.components;

import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import com.example.pgr209exam23.service.SubassemblyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.Collections;

import java.util.Optional;

//Unit tests for the SubassemblyService.
//tests for creating, finding by Id, and fetching all subassemblies.

@SpringBootTest
public class SubassemblyServiceUnitTest {

    @MockBean
    private SubassemblyRepo subassemblyRepo;

    @Autowired
    private SubassemblyService subassemblyService;

    @Test
    void shouldCreateSubassembly() {
        Subassembly subassembly = new Subassembly("New Subassembly");
        when(subassemblyRepo.save(any(Subassembly.class))).thenReturn(subassembly);

        Subassembly createdSubassembly = subassemblyService.createSubassembly(subassembly);

        assert "New Subassembly".equals(createdSubassembly.getSubassemblyName());
    }

    @Test
    void shouldFindSubassemblyById() {
        Long subassemblyId = 1L;
        Subassembly subassembly = new Subassembly("Existing Subassembly");
        subassembly.setSubassemblyId(subassemblyId);
        when(subassemblyRepo.findById(subassemblyId)).thenReturn(Optional.of(subassembly));

        Subassembly foundSubassembly = subassemblyService.findSubassemblyById(subassemblyId);

        assert foundSubassembly != null;
        assert subassemblyId.equals(foundSubassembly.getSubassemblyId());
    }

    @Test
    void shouldGetAllSubassembliesPaged() {
        PageRequest pageable = PageRequest.of(0, 10);
        Subassembly subassembly = new Subassembly("Paged Subassembly");
        Page<Subassembly> subassemblyPage = new PageImpl<>(Collections.singletonList(subassembly));

        when(subassemblyRepo.findAll(pageable)).thenReturn(subassemblyPage);

        Page<Subassembly> result = subassemblyService.getAllSubassemblies(pageable);

        assert result.getContent().size() == 1;
        assert "Paged Subassembly".equals(result.getContent().get(0).getSubassemblyName());
    }

}
