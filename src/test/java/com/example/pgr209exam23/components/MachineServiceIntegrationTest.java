package com.example.pgr209exam23.components;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.service.MachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

//Integration test for the MachineService.
//Uses Spring Boot testing framework.
//performs test-operations for creating and retrieving a machine.


@SpringBootTest
public class MachineServiceIntegrationTest {

    @Autowired
    private MachineService machineService;

    @Test
    @Transactional
    void shouldCreateAndRetrieveMachine() {
        //here we create a new machine
        Machine newMachine = new Machine("New Machine", "Description");

        //here we save the machine
        Machine savedMachine = machineService.createMachine(newMachine);

        assert savedMachine.getMachineId() != null;

        //here we write the expected name
        assert "New Machine".equals(savedMachine.getMachineName());

        //then we retrieve the machine with id, and assert values
        Machine foundMachine = machineService.findMachineById(savedMachine.getMachineId());
        assert foundMachine != null;
        assert "New Machine".equals(foundMachine.getMachineName());
    }

}

