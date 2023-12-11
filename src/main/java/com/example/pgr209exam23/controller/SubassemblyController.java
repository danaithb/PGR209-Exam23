package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.service.SubassemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
        return subassemblyService.getAllSubassemblies(page, size);
    }

    @DeleteMapping("/{id}")
    public void deleteSubassembly(@PathVariable Long id) {
        subassemblyService.deleteSubassemblyById(id);
    }

    @PutMapping("/{id}")
    public Subassembly updateSubassembly(@PathVariable Long id, @RequestBody Subassembly updatedSubassembly) {
        return subassemblyService.updateSubassembly(id, updatedSubassembly);
    }
}