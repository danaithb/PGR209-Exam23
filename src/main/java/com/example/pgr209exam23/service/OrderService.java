package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Customer;
import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.repo.CustomerRepo;
import com.example.pgr209exam23.repo.MachineRepo;
import com.example.pgr209exam23.repo.OrderRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Autowired
    private CustomerRepo customerRepo;
    // Create one
    @Autowired
    private MachineRepo machineRepo;

    public CustomerOrder createOrder(Long customerId, LocalDateTime orderDate, List<Long> machineIds) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        // Create order
        CustomerOrder order = new CustomerOrder(customer, LocalDateTime.now());

        List<Machine> machines = machineRepo.findAllById(machineIds);
        order.setMachines(machines);

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
