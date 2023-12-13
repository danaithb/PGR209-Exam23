package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.service.MachineService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/machines")
public class MachineController {

    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping("/{id}")
    public Machine getMachine(@PathVariable Long id) {
        return machineService.findMachineById(id);
    }

    /*
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
*/

    // Gets all
    @GetMapping
    @Transactional
    public ResponseEntity<Page<Machine>> getAllMachines(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Machine> machines = machineService.getAllMachines(PageRequest.of(page, size));
        return ResponseEntity.ok(machines);
    }

}
