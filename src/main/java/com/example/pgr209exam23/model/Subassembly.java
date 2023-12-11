package com.example.pgr209exam23.model;
//Kilde: Vet clinic eksempel til læreren

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subassembly {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subassembly_seq_gen")
    @SequenceGenerator(name = "subassembly_seq_gen", sequenceName = "subassembly_seq", allocationSize = 1)
    @Column(name = "subassembly_id")
    private Long subassemblyId;

    @Column(name = "subassembly_name")
    private String subassemblyName;

    @OneToMany(mappedBy = "subassembly", cascade = CascadeType.ALL)
    private List<Part> parts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    public Subassembly(String subassemblyName, Machine machine) {
        this.subassemblyName = subassemblyName;
        this.machine = machine;
    }
}

