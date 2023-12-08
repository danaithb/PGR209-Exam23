/*package com.example.pgr209exam23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PartService {
    @Autowired
    public PartService(PartRepo partRepo){
        this.partRepo = partRepo;
    }

    //create one
    public Part createPart(Part part){
        return partRepo.save(part);
    }

    //Get one by id
    public Part findPartById(Long id){
        return partRepo.findById(id).orElse(null);
    }

    //Get all with pagination
    public Page<Part> getParts(int page, int size){
        return partRepo.findAll(PageRequest.of(page, size));
    }

    //Delete one
    public void deletePartById(Long id){
        partRepo.deleteById(id);
    }
}
/*
MAngler:
	- Update one
*/