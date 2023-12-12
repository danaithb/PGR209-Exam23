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

    // Getters and setters

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Subassembly getSubassembly() {
        return subassembly;
    }

    public void setSubassembly(Subassembly subassembly) {
        this.subassembly = subassembly;
    }
}
