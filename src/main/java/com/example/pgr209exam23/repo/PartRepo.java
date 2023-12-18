package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring data JPA repository for part. It extends JPARepository interface.

@Repository
public interface PartRepo extends JpaRepository<Part, Long>{
}