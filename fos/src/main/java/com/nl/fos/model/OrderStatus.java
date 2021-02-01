package com.nl.fos.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


@Entity
public class OrderStatus {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 45)
    private OStatus status;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "orderStatus", targetEntity = Order.class, fetch = FetchType.EAGER)
    private Set<Order> orderStatusOrders;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public OStatus getStatus() {
        return status;
    }

    public void setStatus(OStatus status) {
        this.status = status;
    }

    public Set<Order> getOrderStatusOrders() {
        return orderStatusOrders;
    }

    public void setOrderStatusOrders(final Set<Order> orderStatusOrders) {
        this.orderStatusOrders = orderStatusOrders;
    }

}
