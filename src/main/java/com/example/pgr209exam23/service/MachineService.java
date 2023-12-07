package com.example.pgr209exam23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MachineService {
    private final MachineRepo machineRepo;

    @Autowired
    public MachineService(MachineRepo machineRepo){
        this.machineRepo = machineRepo;
    }

    //get one by id
    public Machine getMachineById(Long id){
        return machineRepo.findById(id).orElse(null);
    }

    //Create one
    public Machine createMachine(Machine machine){
        return machineRepo.save(machine);
    }

    //delete one
    public void deleteMachine(Long id){
        machineRepo.deleteById(id);
    }

    //Get all with pagination
    public Page<Machine> getMachines(int page, int size){
        return MachineRepo.findAll(PageRequest.of(page, size));
    }
    /*


/*
MAngler:
	- Update one
*/
