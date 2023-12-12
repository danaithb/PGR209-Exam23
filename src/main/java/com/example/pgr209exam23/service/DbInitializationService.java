package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DbInitializationService {

    @Autowired
    private SubassemblyRepo subassemblyRepo;

    @PostConstruct
    public void initializeDatabase() {
        Subassembly robotArm = new Subassembly("robotarm", "article123");
        Subassembly robotLeg = new Subassembly("robotleg", "article456");

        subassemblyRepo.save(robotArm);
        subassemblyRepo.save(robotLeg);
    }
}
