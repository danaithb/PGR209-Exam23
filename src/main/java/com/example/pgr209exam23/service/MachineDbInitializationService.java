package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.repo.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MachineDbInitializationService {

    @Autowired
    private MachineRepo machineRepo;

    @PostConstruct
    public void initializeDatabase() {
        Machine robotMachine = new Machine("Robot Machine", "model123");
        Machine assemblyMachine = new Machine("Assembly Machine", "model456");

        machineRepo.save(robotMachine);
        machineRepo.save(assemblyMachine);
    }
}
