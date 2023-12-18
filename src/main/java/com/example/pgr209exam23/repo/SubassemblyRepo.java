package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.Subassembly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring data JPA repository for subassembly. It extends JPARepository interface.

@Repository
public interface SubassemblyRepo extends JpaRepository<Subassembly, Long> {

}
