package com.example.pgr209exam23.model;
//Kilde: Vet clinic eksempel til læreren

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_seq", allocationSize = 1)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

   /* @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Machine> machines = new ArrayList<>();*/

    public Order(Customer customer) {
        this.customer = customer;
    }
}
