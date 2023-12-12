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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subassembly_id")
    private Long subassemblyId;

    @Column(name = "subassembly_name")
    private String subassemblyName;

    @Column(name = "subassembly_article_number")
    private String subassemblyArticleNumber;
    /*
       @OneToMany(mappedBy = "subassembly", cascade = CascadeType.ALL)
        private List<Part> parts = new ArrayLi<>();
    */
        @ManyToOne
        @JoinColumn(name = "machine_id")
        private Machine machine;

    public Subassembly(String subassemblyName, String subassemblyArticleNumber) {
        this.subassemblyName = subassemblyName;
        this.subassemblyArticleNumber = subassemblyArticleNumber;
    }


}

