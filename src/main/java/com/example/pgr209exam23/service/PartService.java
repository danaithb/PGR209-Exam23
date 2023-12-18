package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Part;
import com.example.pgr209exam23.repo.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//Service class for handling Part-related operations. It interacts with the PartRepo to
//perform CRUD operations on Part entities.
@Service
public class PartService {

    private final PartRepo partRepo;
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

    //update one
    public Part updatePart(Part part){
        return partRepo.save(part);
    }
}