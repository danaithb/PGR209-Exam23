package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machine")
public class MachineController {

    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    // Get one machine by ID
    @GetMapping("/{id}")
    public Machine getMachine(@PathVariable Long id) {
        return machineService.findMachineById(id);
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return machineService.createMachine(machine);
    }

    // Update
    @PutMapping("/{id}")
    public Machine updateMachine(@PathVariable Long id, @RequestBody Machine machine) {
        return machineService.updateMachine(id, machine);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable Long id) {
        machineService.deleteMachineById(id);
    }

    // Gets all
    @GetMapping
    public Page<Machine> getAllMachines(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return machineService.getAllMachines(page, size);
    }
}
