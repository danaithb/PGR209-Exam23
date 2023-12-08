/*package com.example.pgr209exam23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SubassemblyService {

    @Autowired
    public SubassemblyService(SubassemblyRepo subassemblyRepo){
        this.subassemblyRepo = subassemblyRepo;
    }

    //create one
    public Subassembly createSubassembly(Subassembly subassembly){
        return subassemblyRepo.save(subassembly);
    }

    //Get one by id
    public Subassembly findSubassemblyById(Long id){
        return subassemblyRepo.findById(id).orElse(null);
    }

    //Get all with pagination
    public Page<Subassembly> getSubassemblies(int page, int size){
        return subassemblyRepo.findAll(PageRequest.of(page, size));
    }

    //Delete one
    public void deleteSubassemblyById(Long id){
        subassemblyRepo.deleteById(id);
    }
}

/*
MAngler:
	- Update one
*/
