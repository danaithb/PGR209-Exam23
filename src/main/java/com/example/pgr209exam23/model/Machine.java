package com.example.pgr209exam23.model;

import jakarta.persistence.*;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_seq_gen")
    @SequenceGenerator(name = "machine_seq_gen", sequenceName = "machine_seq", allocationSize = 1)
    private Long machineId;

    @Column(nullable = false)
    private String machineName;
    private String description;


    public Machine(String machineName, String description) {
        this.machineName = machineName;
        this.description = description;
    }

    public Machine() {

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

    @Override
    public String toString() {
        return "Machine{" +
                "machineId=" + machineId +
                ", machineName='" + machineName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
