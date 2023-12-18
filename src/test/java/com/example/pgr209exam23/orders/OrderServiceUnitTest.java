package com.example.pgr209exam23.orders;

import com.example.pgr209exam23.model.Customer;
import com.example.pgr209exam23.model.CustomerOrder;
import com.example.pgr209exam23.repo.OrderRepo;
import com.example.pgr209exam23.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//unit tests for the OrderService with mock objects.
//tests the update functionality of the OrderService.

@SpringBootTest
public class OrderServiceUnitTest {
    @MockBean
    private OrderRepo orderRepo;

    @Autowired
    private OrderService orderService;

    @Test
    void shouldUpdateOrder() {
        Customer customer = new Customer("Kine", "Kine@gmail.no");
        LocalDateTime orderDate = LocalDateTime.parse("2023-10-20T18:08:00");
        CustomerOrder originalOrder = new CustomerOrder(customer, orderDate);

        when(orderRepo.save(any(CustomerOrder.class))).thenReturn(originalOrder);
        CustomerOrder updatedOrder = orderService.updateOrder(originalOrder);

        assert orderDate.equals(updatedOrder.getOrderDate());

    }


}