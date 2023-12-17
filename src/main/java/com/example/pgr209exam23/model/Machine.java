package com.example.pgr209exam23.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_seq_gen")
    @SequenceGenerator(name = "machine_seq_gen", sequenceName = "machine_seq", allocationSize = 1)
    private Long machineId;

    @Column(nullable = false)
    private String machineName;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "machine_id")
    private List<Subassembly> subassemblies = new ArrayList<>();

    public Machine() {
    }

    public Machine(String machineName, String description) {
        this.machineName = machineName;
        this.description = description;
    }

    // Getters og setters
    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getSubassemblyIds() {
        return subassemblies.stream()
                .map(Subassembly::getSubassemblyId)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String subassemblyIds = getSubassemblyIds().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        return "Machine{" +
                "machineId=" + machineId +
                ", machineName='" + machineName + '\'' +
                ", description='" + description + '\'' +
                ", subassemblyIds=" + subassemblyIds +
                '}';
    }

}
