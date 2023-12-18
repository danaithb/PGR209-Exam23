package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    //Get one by id
    public Subassembly findSubassemblyById(Long id) {
        return subassemblyRepo.findById(id).orElse(null);
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
        return subassemblyRepo.findById(id).map(subassembly -> {
            subassembly.setSubassemblyName(updatedSubassembly.getSubassemblyName());

            return subassemblyRepo.save(subassembly);
        }).orElseGet(() -> {
            updatedSubassembly.setSubassemblyId(id);
            // Ikke sett subassemblyArticleNumber her heller
            return subassemblyRepo.save(updatedSubassembly);
        });
    }

}

