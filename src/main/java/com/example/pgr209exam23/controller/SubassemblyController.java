package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.globalExeption.ResourceNotFoundException;
import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.service.SubassemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//RESTful API controller for part. Interacts with partService.
@RestController
@RequestMapping("/api/subassembly")
public class SubassemblyController {

    private final SubassemblyService subassemblyService;
    @Autowired
    public SubassemblyController(SubassemblyService subassemblyService) {
        this.subassemblyService = subassemblyService;
    }

    //Get one by id
    @GetMapping("/{id}")
    public Subassembly getSubassembly(@PathVariable Long id) {
        return subassemblyService.findSubassemblyById(id);
    }

    //Get all with pagination
    @GetMapping
    public Page<Subassembly> getAllSubassembliesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Subassembly> result = subassemblyService.getAllSubassemblies(PageRequest.of(page, size));
        System.out.println("Retrieved " + result.getTotalElements() + " subassemblies in controller");
        return result;
    }

    //Create one
    @PostMapping
    public Subassembly createSubassembly(@RequestBody Subassembly subassembly) {
        return subassemblyService.createSubassembly(subassembly);
    }

    //Delete one
    @DeleteMapping("/{id}")
    public void deleteSubassembly(@PathVariable Long id) {
        subassemblyService.deleteSubassemblyById(id);
    }

    //Update one
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubassembly(@PathVariable Long id, @RequestBody Subassembly updatedSubassembly) {
        try {
            Subassembly updated = subassemblyService.updateSubassembly(id, updatedSubassembly);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            // Return a 404 Not Found response if the subassembly is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @ExceptionHandler(SubassemblyService.SubassemblyNotFoundException.class)
    public ResponseEntity<?> handleSubassemblyNotFoundException(SubassemblyService.SubassemblyNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}