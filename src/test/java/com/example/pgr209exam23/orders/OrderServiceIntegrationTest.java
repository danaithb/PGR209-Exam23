package com.example.pgr209exam23.orders;

import com.example.pgr209exam23.model.Customer;
import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

//Integration tests for the OrderService.
//Tests the creation and retrieval of orders using the OrderService.

@SpringBootTest
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    void shouldCreateAndRetrieveOrder() {
        //here we create a new customer
        Customer customer = new Customer("Lilo", "Lilo@hotmail.com");
        //adds order date
        LocalDateTime orderDate = LocalDateTime.parse("2023-12-05T18:10:15");
        //then we create a new order with customer and order date
        CustomerOrder newOrder = new CustomerOrder(customer, orderDate);

        //create the order and retrieves the saves order
        CustomerOrder savedOrder = orderService.createOrder(newOrder);

        //make assertations for the saved order
        assert savedOrder.getOrderId() != null;
        assert "Lilo".equals(savedOrder.getCustomer().getCustomerName());
        assert "Lilo@hotmail.com".equals(savedOrder.getCustomer().getCustomerEmail());
        assert orderDate.equals(savedOrder.getOrderDate());

        //lastly we retrieve the order with id and assert the info
        CustomerOrder retrievedOrder = orderService.findOrderById(savedOrder.getOrderId());
        assert retrievedOrder != null;
        assert "Lilo".equals(retrievedOrder.getCustomer().getCustomerName());
        assert "Lilo@hotmail.com".equals(retrievedOrder.getCustomer().getCustomerEmail());
        assert orderDate.equals(retrievedOrder.getOrderDate());
    }
}