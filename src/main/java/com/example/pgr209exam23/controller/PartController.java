package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Part;
import com.example.pgr209exam23.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//RESTful API controller for part. Interacts with PartService.
@RestController
@RequestMapping("/api/part")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    //Get one by id
    @GetMapping("/{id}")
    public Part getPart(@PathVariable Long id) {
        return partService.findPartById(id);
    }

    //Create one
     @PostMapping
     public ResponseEntity<Part> createPart(@RequestBody Part part) {
         Part newPart = partService.createPart(part);
         return new ResponseEntity<>(newPart, HttpStatus.CREATED);
     }

    //Delete one
     @DeleteMapping("/{id}")
     public void deletePart(@PathVariable Long id) {
         partService.deletePartById(id);
     }

    //Update one
    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@PathVariable Long id, @RequestBody Part part) {
        Part updatedPart = partService.updatePart(id, part);
        return new ResponseEntity<>(updatedPart, HttpStatus.OK);
    }

    //Get all with pagination
    @GetMapping
    public ResponseEntity<Page<Part>> getParts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Part> parts = partService.getParts(page, size);
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }
}