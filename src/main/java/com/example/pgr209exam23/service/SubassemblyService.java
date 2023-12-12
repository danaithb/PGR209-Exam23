package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    //Get all with pagination

    // Get all with pagination
    public Page<Subassembly> getAllSubassemblies(Pageable pageable) {
        Page<Subassembly> result = subassemblyRepo.findAll(pageable);
        System.out.println("Retrieved " + result.getTotalElements() + " subassemblies");
        return result;
    }



   /* public Page<Subassembly> getAllSubassemblies(Pageable pageable) {
        List<Subassembly> subassemblies = Arrays.asList(
                new Subassembly("robotarm", null, "article123"),
                new Subassembly("robotleg", null, "article456")
        );

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Subassembly> resultList;

        if (subassemblies.size() < startItem) {
            resultList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, subassemblies.size());
            resultList = subassemblies.subList(startItem, toIndex);
        }

        return new PageImpl<>(resultList, PageRequest.of(currentPage, pageSize), subassemblies.size());
    }*/

    //Delete one
    public void deleteSubassemblyById(Long id) {
        subassemblyRepo.deleteById(id);
    }

    public Subassembly updateSubassembly(Long id, Subassembly updatedSubassembly) {
        return subassemblyRepo.findById(id).map(subassembly -> {
            subassembly.setSubassemblyName(updatedSubassembly.getSubassemblyName());
            subassembly.setSubassemblyArticleNumber(updatedSubassembly.getSubassemblyArticleNumber());

            return subassemblyRepo.save(subassembly);
        }).orElseGet(() -> {
            updatedSubassembly.setSubassemblyId(id);
            return subassemblyRepo.save(updatedSubassembly);
        });
    }
}

