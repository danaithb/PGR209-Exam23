package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.repo.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MachineService {
    private final MachineRepo machineRepo;

    @Autowired
    public MachineService(MachineRepo machineRepo) {
        this.machineRepo = machineRepo;
    }

    // Retrieves a machine by its ID with subassemblies
    @Transactional(readOnly = true)
    public Machine findMachineById(Long id) {
        return machineRepo.findById(id).map(machine -> {
            machine.getSubassemblies().size(); // Trigger loading of subassemblies
            return machine;
        }).orElse(null);
    }


    // Creates a new machine
    public Machine createMachine(Machine machine) {
        return machineRepo.save(machine);
    }

    // Deletes a machine by its ID
    public void deleteMachineById(Long id) {
        machineRepo.deleteById(id);
    }

    // Gets all machines with pagination
    public Page<Machine> getAllMachines(int page, int size) {
        return machineRepo.findAll(PageRequest.of(page, size));
    }

    // Updates a machine
    public Machine updateMachine(Long id, Machine updatedMachine) {
        return machineRepo.findById(id).map(machine -> {
            machine.setMachineName(updatedMachine.getMachineName());
            machine.setDescription(updatedMachine.getDescription());

            return machineRepo.save(machine);
        }).orElseGet(() -> {
            updatedMachine.setMachineId(id);
            return machineRepo.save(updatedMachine);
        });
    }
}
