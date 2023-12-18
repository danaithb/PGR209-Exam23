package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//RESTful API controller for order. Interacting with orderService to perform our methods.
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Get one by id
    @GetMapping("/{id}")
    public CustomerOrder getOrder(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    //Create one
    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder order) {
        CustomerOrder createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    //Delete one
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }

    //Update one
    @PutMapping
    public CustomerOrder updateOrder(@RequestBody CustomerOrder order) {
        return orderService.updateOrder(order);
    }

    //Get all with pagination
    @GetMapping
    public Page<CustomerOrder> getOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return orderService.getOrders(page, size);
    }
}
