package com.example.pgr209exam23.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//This class represents the Part entity in the database. It includes fields such as partId,
//partName, and a reference to the parent Subassembly.JPA annotations are used to create a
//relational database.
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

   // The parent Subassembly to which the part belongs. This field is annotated with @JsonIgnore
   // to avoid a never-ending loop when converting the object to JSON format
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subassembly_id")
    private Subassembly subassembly;


    public Part(String partName) {
        this.partName = partName;
    }
}