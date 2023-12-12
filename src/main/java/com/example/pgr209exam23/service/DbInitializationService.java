package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.MachineRepo;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DbInitializationService {

    @Autowired
    private SubassemblyRepo subassemblyRepo;

    @Autowired
    private MachineRepo machineRepo;

    @PostConstruct
    public void initializeDatabase() {
        Subassembly robotArm = new Subassembly("robotarm", "article123");
        Subassembly robotLeg = new Subassembly("robotleg", "article456");

        subassemblyRepo.save(robotArm);
        subassemblyRepo.save(robotLeg);


        Machine machine1 = new Machine("machine1", "description1");
        Machine machine2 = new Machine("machine2", "description2");

        machineRepo.save(machine1);
        machineRepo.save(machine2);
    }
    }

