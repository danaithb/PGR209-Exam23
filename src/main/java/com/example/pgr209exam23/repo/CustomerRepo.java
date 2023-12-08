package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//kilde ownerRepo Vet clinic example
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
