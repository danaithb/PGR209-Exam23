package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.repo.MachineRepo;
import com.example.pgr209exam23.repo.OrderRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OrderService {


    private final OrderRepo orderRepo;
    private final MachineRepo machineRepo; //

    @Autowired
    public OrderService(OrderRepo orderRepo, MachineRepo machineRepo) { // Modifiser konstruktøren
        this.orderRepo = orderRepo;
        this.machineRepo = machineRepo;
    }

    // Create one
    public CustomerOrder createOrder(CustomerOrder order) {
        // Sjekk om ordren har maskiner og oppdater dem fra databasen
        if (order.getMachines() != null && !order.getMachines().isEmpty()) {
            List<Machine> managedMachines = new ArrayList<>();
            for (Machine machine : order.getMachines()) {
                // Hent den administrerte maskinen fra databasen
                Machine managedMachine = machineRepo.findById(machine.getMachineId()).orElseThrow(
                        () -> new EntityNotFoundException("Machine not found with id: " + machine.getMachineId())
                );
                managedMachines.add(managedMachine);
            }
            // Sett de administrerte maskinene til ordren
            order.setMachines(managedMachines);
        }
        // Lagre ordren i databasen
        return orderRepo.save(order);
    }


    // Get one by id
    public CustomerOrder findOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    // Get all with pagination
    public Page<CustomerOrder> getOrders(int page, int size) {
        return orderRepo.findAll(PageRequest.of(page, size));
    }

    // Delete one
    public void deleteOrderById(Long id) {
        orderRepo.deleteById(id);
    }

    // Update one
    public CustomerOrder updateOrder(CustomerOrder order) {
        return orderRepo.save(order);
    }
}
