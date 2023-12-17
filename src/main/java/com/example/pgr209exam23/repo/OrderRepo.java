package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder, Long> {


}
