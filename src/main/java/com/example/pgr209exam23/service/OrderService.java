/*
package com.example.pgr209exam23.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    //create one
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    //Get one by id
    public Order findOrderById(Long id){
        return orderRepo.findById(id).orElse(null);
    }

    //Get all with pagination
    public Page<Order> getOrders(int page, int size){
        return orderRepo.findAll(PageRequest.of(page, size));
    }

    //Delete one
    public void deleteOrderById(Long id){
        orderRepo.deleteById(id);
    }
}
/*
MAngler:
	- Update one
*/
