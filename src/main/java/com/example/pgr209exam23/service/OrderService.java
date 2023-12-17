package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // Create one
    public CustomerOrder createOrder(CustomerOrder order) {
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
