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

@SpringBootTest
public class MachineServiceUnitTest {

    @MockBean
    private MachineRepo machineRepo;

    @Autowired
    private MachineService machineService;

    @Test
    void shouldCreateMachine() {
        Machine machine = new Machine("Machine Name", "Description");
        when(machineRepo.save(any(Machine.class))).thenReturn(machine);

        Machine createdMachine = machineService.createMachine(machine);

        assert "Machine Name".equals(createdMachine.getMachineName());
    }

    @Test
    void shouldFindMachineById() {
        Long machineId = 1L;
        Machine machine = new Machine("Existing Machine", "Description");
        machine.setMachineId(machineId);
        when(machineRepo.findById(machineId)).thenReturn(Optional.of(machine));

        Machine foundMachine = machineService.findMachineById(machineId);

        assert foundMachine != null;
        assert machineId.equals(foundMachine.getMachineId());
    }


}

