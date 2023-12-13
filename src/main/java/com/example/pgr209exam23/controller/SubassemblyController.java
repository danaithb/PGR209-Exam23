package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.service.SubassemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;



@RestController
@RequestMapping("/api/subassembly")
public class SubassemblyController {

    private final SubassemblyService subassemblyService;

    @Autowired
    public SubassemblyController(SubassemblyService subassemblyService) {
        this.subassemblyService = subassemblyService;
    }

    @GetMapping("/{id}")
    public Subassembly getSubassembly(@PathVariable Long id) {
        return subassemblyService.findSubassemblyById(id);
    }

    @GetMapping
    public Page<Subassembly> getAllSubassembliesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Subassembly> result = subassemblyService.getAllSubassemblies(PageRequest.of(page, size));
        System.out.println("Retrieved " + result.getTotalElements() + " subassemblies in controller");
        return result;
    }
    /*
    @DeleteMapping("/{id}")
    public void deleteSubassembly(@PathVariable Long id) {
        subassemblyService.deleteSubassemblyById(id);
    }

    @PutMapping("/{id}")
    public Subassembly updateSubassembly(@PathVariable Long id, @RequestBody Subassembly updatedSubassembly) {
        return subassemblyService.updateSubassembly(id, updatedSubassembly);
    }*/
}