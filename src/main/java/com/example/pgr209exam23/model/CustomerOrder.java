package com.example.pgr209exam23.model;
//Kilde: Vet clinic eksempel til læreren

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//This class represents the CustomerOrder entity in the database. It includes fields
//such as orderId, customer, orderDate, address, and machines. JPA annotations are used to
//establish relationships and create a relational database.

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

    //The address associated with the order
   @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

   //a list of machines for the order
   @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
   private List<Machine> machines = new ArrayList<>();

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerOrder> orders;
    public CustomerOrder(Customer customer, LocalDateTime orderDate) {
        this.customer = customer;
        this.orderDate = orderDate;

    }
}
