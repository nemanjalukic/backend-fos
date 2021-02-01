package com.nl.fos.model;

import javax.persistence.*;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)  
    private Date orderTime;

    @Column
    private Double finalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    
    public Order() {
		super();
	}

	public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(final Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(final Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(final OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderOrderitems) {
        this.orderItems = orderOrderitems;
    }

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
    
    

}
