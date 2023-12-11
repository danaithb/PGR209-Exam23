package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.service.SubassemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Subassembly createSubassembly(@RequestBody Subassembly subassembly){
        return subassemblyService.createSubassembly(subassembly);
    }

    @PostMapping
    public Page<Subassembly> getSubassembliesPaged
            (@RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        return subassemblyService.getAllSubassemblies(page, size);
    }

    @DeleteMapping("/{id}")
    public void deleteSubassembly(@PathVariable Long id) {
        subassemblyService.deleteSubassemblyById(id);
    }

    @PutMapping
    public Subassembly updateSubassembly(@RequestBody Subassembly subassembly) {
        return subassemblyService.updateSubassembly(subassembly);
    }

}
