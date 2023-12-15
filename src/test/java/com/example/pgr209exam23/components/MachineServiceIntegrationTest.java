package com.example.pgr209exam23.components;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.service.MachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MachineServiceIntegrationTest {

    @Autowired
    private MachineService machineService;

    @Test
    @Transactional
    void shouldCreateAndRetrieveMachine() {
        Machine newMachine = new Machine("New Machine", "Description");
        Machine savedMachine = machineService.createMachine(newMachine);

        assert savedMachine.getMachineId() != null;
        assert "New Machine".equals(savedMachine.getMachineName());

        Machine foundMachine = machineService.findMachineById(savedMachine.getMachineId());
        assert foundMachine != null;
        assert "New Machine".equals(foundMachine.getMachineName());
    }

}

