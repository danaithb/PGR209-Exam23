package com.example.pgr209exam23.components;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.repo.MachineRepo;
import com.example.pgr209exam23.service.MachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

//Unit tests for MachineService using the Mockito framework.
//mocks the MachineRepo and performs tests for creating a machine and finding machine by Id.

@SpringBootTest
public class MachineServiceUnitTest {

    @MockBean
    private MachineRepo machineRepo;

    @Autowired
    private MachineService machineService;

    @Test
    void shouldCreateMachine() {
        //here we create a machine
        Machine machine = new Machine("Machine Name", "Description");

        //mock the save operations in repo
        when(machineRepo.save(any(Machine.class))).thenReturn(machine);

        //call createOrder
        Machine createdMachine = machineService.createMachine(machine);

        //write the expceted name
        assert "Machine Name".equals(createdMachine.getMachineName());
    }

    @Test
    void shouldFindMachineById() {
        //here we write test data
        Long machineId = 1L;
        Machine machine = new Machine("Existing Machine", "Description");
        machine.setMachineId(machineId);

        //mock the findById in the repo
        when(machineRepo.findById(machineId)).thenReturn(Optional.of(machine));

        //call findMachineById
        Machine foundMachine = machineService.findMachineById(machineId);

        //write the expected id using assert
        assert foundMachine != null;
        assert machineId.equals(foundMachine.getMachineId());
    }


}

