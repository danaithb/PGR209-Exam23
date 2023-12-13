package com.example.pgr209exam23.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Long partId;

    @Column(name = "part_name")
    private String partName;


    @ManyToOne
    @JoinColumn(name = "subassembly_id")
    @JsonIgnore
    private Subassembly subassembly;

    public Part(String partName) {
        this.partName = partName;
    }

}
