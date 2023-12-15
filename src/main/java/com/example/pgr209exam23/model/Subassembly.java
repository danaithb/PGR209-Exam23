package com.example.pgr209exam23.model;

import jakarta.persistence.*;

@Entity
public class Subassembly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subassemblyId;

    @Column(nullable = false)
    private String subassemblyName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    // Konstruktører, getters, og setters
    public Subassembly() {
    }

    public Subassembly(String subassemblyName, Machine machine) {
        this.subassemblyName = subassemblyName;
        this.machine = machine;
    }

    public Long getSubassemblyId() {
        return subassemblyId;
    }

    public void setSubassemblyId(Long subassemblyId) {
        this.subassemblyId = subassemblyId;
    }

    public String getSubassemblyName() {
        return subassemblyName;
    }

    public void setSubassemblyName(String subassemblyName) {
        this.subassemblyName = subassemblyName;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return "Subassembly{" +
                "subassemblyId=" + subassemblyId +
                ", subassemblyName='" + subassemblyName + '\'' +
                ", machine=" + (machine != null ? machine.getMachineId() : null) +
                '}';
    }
}
