package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring data JPA repository for order. It extends JPARepository interface.
@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder, Long> {

}
