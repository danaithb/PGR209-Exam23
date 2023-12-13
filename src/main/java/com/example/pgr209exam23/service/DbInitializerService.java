package com.example.pgr209exam23.service;

import com.example.pgr209exam23.model.Machine;
import com.example.pgr209exam23.model.Part;
import com.example.pgr209exam23.model.Subassembly;
import com.example.pgr209exam23.repo.MachineRepo;
import com.example.pgr209exam23.repo.PartRepo;
import com.example.pgr209exam23.repo.SubassemblyRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DbInitializerService {

    private final EntityManager entityManager;
    private final PartRepo partRepo;
    private final MachineRepo machineRepo;
    private final SubassemblyRepo subassemblyRepo;

    @Autowired
    public DbInitializerService(EntityManager entityManager, PartRepo partRepo, MachineRepo machineRepo, SubassemblyRepo subassemblyRepo) {
        this.entityManager = entityManager;
        this.partRepo = partRepo;
        this.machineRepo = machineRepo;
        this.subassemblyRepo = subassemblyRepo;
    }

    @Transactional
    @PostConstruct
    public void initializeDatabase() {

        Part part1 = new Part("Part1");
        partRepo.save(part1);

        Subassembly subassembly = new Subassembly("Subassembly1", "SA001");
        subassemblyRepo.save(subassembly);

        Machine machine = new Machine("Machine1", "Machine description");

        machineRepo.save(machine);
    }
}

