package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.example.pgr209exam23.globalExeption.ResourceNotFoundException;

//Service class for handling Subassembly-related operations. Interacts with the SubassemblyRepo
//to perform CRUD operations on Subassembly entities.
@Service
public class SubassemblyService {

    private final SubassemblyRepo subassemblyRepo;

    @Autowired
    public SubassemblyService(SubassemblyRepo subassemblyRepo) {
        this.subassemblyRepo = subassemblyRepo;
    }

    //create one
    public Subassembly createSubassembly(Subassembly subassembly) {
        return subassemblyRepo.save(subassembly);
    }

    public static class SubassemblyNotFoundException extends RuntimeException {
        public SubassemblyNotFoundException(String message) {
            super(message);
        }
    }

    //Get one by id
    public Subassembly findSubassemblyById(Long id) {
        return subassemblyRepo.findById(id).orElseThrow(() ->
                new SubassemblyNotFoundException("Subassembly not found for this id :: " + id)
        );
    }

    // Get all with pagination
    public Page<Subassembly> getAllSubassemblies(Pageable pageable) {
        Page<Subassembly> result = subassemblyRepo.findAll(pageable);
        System.out.println("Retrieved " + result.getTotalElements() + " subassemblies");
        return result;
    }

    //Delete one
    public void deleteSubassemblyById(Long id) {
        subassemblyRepo.deleteById(id);
    }

    //Update one
    public Subassembly updateSubassembly(Long id, Subassembly updatedSubassembly) {
        // Check if the subassembly with the given ID exists
        Optional<Subassembly> existingSubassembly = subassemblyRepo.findById(id);
        if (!existingSubassembly.isPresent()) {
                throw new ResourceNotFoundException("Subassembly not found for this id :: " + id);
        }
       Subassembly subassemblyToUpdate = existingSubassembly.get();
        subassemblyToUpdate.setSubassemblyName(updatedSubassembly.getSubassemblyName());
         return subassemblyRepo.save(subassemblyToUpdate);
    }

}

