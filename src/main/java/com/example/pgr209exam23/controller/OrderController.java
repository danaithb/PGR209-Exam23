package com.example.pgr209exam23.controller;

import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public CustomerOrder getOrder(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder customerOrder) {
        CustomerOrder createdOrder = orderService.createOrder(
                customerOrder.getCustomer().getCustomerId(),
                customerOrder.getOrderDate(),
                extractMachineIds(customerOrder.getMachines())
        );

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }


    private List<Long> extractMachineIds(List<Machine> machines) {
        List<Long> machineIds = new ArrayList<>();
        for (Machine machine : machines) {
            machineIds.add(machine.getMachineId());
        }
        return machineIds;
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }

    @PutMapping
    public CustomerOrder updateOrder(@RequestBody CustomerOrder order) {
        return orderService.updateOrder(order);
    }

    @GetMapping
    public Page<CustomerOrder> getOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return orderService.getOrders(page, size);
    }
}
