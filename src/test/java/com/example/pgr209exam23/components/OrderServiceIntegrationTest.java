package com.example.pgr209exam23.components;

import com.example.pgr209exam23.model.Customer;
import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@SpringBootTest
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    void shouldCreateAndRetrieveOrder() {
        Customer customer = new Customer("customerName", "customerEmail");
        LocalDateTime orderDate = LocalDateTime.parse("2023-12-13T18:00:00");
        CustomerOrder newOrder = new CustomerOrder(customer, orderDate);

        CustomerOrder savedOrder = orderService.createOrder(newOrder);

        assert savedOrder.getOrderId() != null;
        assert "customerName".equals(savedOrder.getCustomer().getCustomerName());
        assert "customerEmail".equals(savedOrder.getCustomer().getCustomerEmail());
        assert orderDate.equals(savedOrder.getOrderDate());

        CustomerOrder retrievedOrder = orderService.findOrderById(savedOrder.getOrderId());
        assert retrievedOrder != null;
        assert "customerName".equals(retrievedOrder.getCustomer().getCustomerName());
        assert "customerEmail".equals(retrievedOrder.getCustomer().getCustomerEmail());
        assert orderDate.equals(retrievedOrder.getOrderDate());
    }
}
