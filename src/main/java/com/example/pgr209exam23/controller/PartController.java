package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Customer;
import com.example.pgr209exam23.model.Part;
import com.example.pgr209exam23.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/parts")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/{id}")
    public Part getPart(@PathVariable Long id) {
        return partService.findPartById(id);
    }

   /* @PostMapping
    public ResponseEntity<Part> createPart(@RequestBody Part part) {
        Part newPart = partService.createPart(part);
        return new ResponseEntity<>(newPart, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deletePart(@PathVariable Long id) {
        partService.deletePartById(id);
    }

    @PutMapping
    public Part updatePart(@RequestBody Part part) {
        return partService.updatePart(part);
    }
*/
    @GetMapping
    public ResponseEntity<Page<Part>> getParts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Part> parts = partService.getParts(page, size);
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }
}
