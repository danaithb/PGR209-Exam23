package com.example.pgr209exam23.model;
//Kilde: Vet clinic eksempel til læreren

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_seq", allocationSize = 1)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

   /* @ManyToOne
    @JoinColumn(name = "address_id") // Add this annotation
    private Address address;*/

   /* @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Machine> machines = new ArrayList<>();*/

    public CustomerOrder(Customer customer, LocalDateTime orderDate) {
        this.customer = customer;
        this.orderDate = orderDate;

    }
}
