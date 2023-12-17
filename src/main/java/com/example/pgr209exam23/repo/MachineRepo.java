package com.example.pgr209exam23.repo;

import com.example.pgr209exam23.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MachineRepo extends JpaRepository<Machine, Long> {
    }
