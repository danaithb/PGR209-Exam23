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
        Customer customer = new Customer("Lilo", "Lilo@hotmail.com");
        LocalDateTime orderDate = LocalDateTime.parse("2023-12-05T18:10:15");
        CustomerOrder newOrder = new CustomerOrder(customer, orderDate);

        CustomerOrder savedOrder = orderService.createOrder(newOrder);

        assert savedOrder.getOrderId() != null;
        assert "Lilo".equals(savedOrder.getCustomer().getCustomerName());
        assert "Lilo@hotmail.com".equals(savedOrder.getCustomer().getCustomerEmail());
        assert orderDate.equals(savedOrder.getOrderDate());

        CustomerOrder retrievedOrder = orderService.findOrderById(savedOrder.getOrderId());
        assert retrievedOrder != null;
        assert "Lilo".equals(retrievedOrder.getCustomer().getCustomerName());
        assert "Lilo@hotmail.com".equals(retrievedOrder.getCustomer().getCustomerEmail());
        assert orderDate.equals(retrievedOrder.getOrderDate());
    }
}