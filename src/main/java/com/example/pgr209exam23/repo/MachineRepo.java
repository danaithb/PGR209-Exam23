package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring data JPA repository for machine. It extends JPARepository interface.
@Repository
public interface MachineRepo extends JpaRepository<Machine, Long> {
    }
