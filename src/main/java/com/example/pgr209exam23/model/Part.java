package com.example.pgr209exam23.model;

//Kilde: Vet clinic eksempel til læreren
/*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(name = "part_id")
    private Long partId;

    @Column(name = "part_name")
    private String partName;


    @ManyToOne
    @JoinColumn(name = "subassembly_id")
    private Subassembly subassembly;

    public Part(String partName, Subassembly subassembly) {
        this.partName = partName;
        this.subassembly = subassembly;
    }
}

*/