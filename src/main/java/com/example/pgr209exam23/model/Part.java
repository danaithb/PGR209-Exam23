package com.example.pgr209exam23.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "part_seq_gen")
    @SequenceGenerator(name = "part_seq_gen", sequenceName = "part_seq", allocationSize = 1)
    private Long partId;
    
    @Column(name = "part_name")
    private String partName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subassembly_id")
    private Subassembly subassembly;


    public Part(String partName) {
        this.partName = partName;
    }
}