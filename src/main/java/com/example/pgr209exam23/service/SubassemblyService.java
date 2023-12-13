package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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



}

