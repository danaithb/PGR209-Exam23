package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring data JPA repository for address. It extends JPARepository interface.
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
