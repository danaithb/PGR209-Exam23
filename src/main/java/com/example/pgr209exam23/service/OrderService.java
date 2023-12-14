package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.*;
import com.example.pgr209exam23.repo.CustomerRepo;
import com.example.pgr209exam23.repo.MachineRepo;
import com.example.pgr209exam23.repo.OrderRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    private final List<Customer> inMemoryCustomers = new ArrayList<>();
    @Autowired
    private CustomerRepo customerRepo;
    // Create one
    @Autowired
    private MachineRepo machineRepo;


    public OrderService(CustomerRepo customerRepo, MachineRepo machineRepo, OrderRepo orderRepo) {
        this.customerRepo = customerRepo;
        this.machineRepo = machineRepo;
        this.orderRepo = orderRepo;
    }


    private Customer getCustomerById(Long customerId) {
        return inMemoryCustomers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }
    /*
    public CustomerOrder createOrder(Long customerId, LocalDateTime orderDate, List<Long> machineIds) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        List<Machine> machines = machineRepo.findAllById(machineIds);


        if (machines.size() != machineIds.size()) {
            throw new EntityNotFoundException("One or more machines not found");
        }


        CustomerOrder order = new CustomerOrder(customer, orderDate);
        order.setMachines(machines);


        for (Machine machine : machines) {
            machine.setOrder(order);


            List<Subassembly> subassemblies = machine.getSubassemblies();
            for (Subassembly subassembly : subassemblies) {

                List<Part> parts = subassembly.getParts();
                for (Part part : parts) {

                }
            }
        }

        return orderRepo.save(order);
    }
*/




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
