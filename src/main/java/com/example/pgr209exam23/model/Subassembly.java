package com.example.pgr209exam23.model;

import jakarta.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Subassembly {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subassembly_seq_gen")
    @SequenceGenerator(name = "subassembly_seq_gen", sequenceName = "subassembly_seq", allocationSize = 1)
    private Long subassemblyId;

    @Column(nullable = false)
    private String subassemblyName;

    @OneToMany(mappedBy = "subassembly", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Part> parts = new ArrayList<>();

    public Subassembly() {}

    public Subassembly(String subassemblyName) {
        this.subassemblyName = subassemblyName;
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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public List<Long> getPartIds() {
        return parts.stream()
                .map(Part::getPartId)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String partIds = getPartIds().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        return "Subassembly{" +
                "subassemblyId=" + subassemblyId +
                ", subassemblyName='" + subassemblyName + '\'' +
                ", parts=" + partIds +
                '}';
    }
}

