package com.nl.fos.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.nl.fos.model.Customer;
import com.nl.fos.model.OStatus;
import com.nl.fos.model.Restaurant;
import com.nl.fos.model.Order;
import com.nl.fos.model.OrderItem;
import com.nl.fos.model.OrderStatus;

import com.nl.fos.repository.OrderStatusRepository;
import com.nl.fos.service.OrderService;
import com.nl.fos.service.UserService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OrderController {
	
    @Autowired
    UserService userService;
    
    @Autowired
    OrderService orderService;
    
    @Autowired
    OrderStatusRepository orderStatusRepository;
    
	
    @PostMapping("/cart")
    public ResponseEntity<Boolean> checkout(@RequestBody OrderItem[] items, Principal principal) {
    	try {
    	Customer customer = userService.findCustomer(principal.getName());
    	Restaurant restaurant= userService.findRestaurant(items[0].getFoodItem().getRestaurant().getUsername());
    	
    	Order order=new Order();
    	
    	order.setCustomer(customer);
    	order.setRestaurant(restaurant);
    	double finalPrice=0;
    	
    	for(OrderItem i: items) {
    		i.setPrice(i.getQuantity()*i.getFoodItem().getPrice());
    		finalPrice+=i.getPrice();
    		i.getFoodItem().setRestaurant(restaurant);
    		i.setOrder(order);
    	}
    	order.setOrderItems(Arrays.asList(items));
    	order.setFinalPrice(finalPrice);
    	order.setOrderTime(new Date());
    	order.setRestaurant(items[0].getFoodItem().getRestaurant());
    	OrderStatus orderStatus=orderStatusRepository.findByStatus(OStatus.NEW).get();
    	order.setOrderStatus(orderStatus);
    	order=orderService.save(order);
        return ResponseEntity.ok(true);
    	}
    	catch (Exception e) {
    		 return ResponseEntity.badRequest().build();
		}
    }
    
    @GetMapping("/order")
    public ResponseEntity<List<Order> > orderList(Authentication authentication) {
    	List<Order> orders= new ArrayList<Order>();
    	
    	if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
    	orders = orderService.getCustomerOrders(authentication.getName());
    	}
    	else {
    		orders = orderService.getRestaurantOrders(authentication.getName());
    	}
    	 return ResponseEntity.ok(orders);
    }


    @PatchMapping("/order/cancel/{id}")
    public ResponseEntity<Order> cancel(@PathVariable("id") Long orderId, Authentication authentication) {
        Order order = orderService.findById(orderId);
        if (!authentication.getName().equals(order.getCustomer().getUsername()) && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.cancel(order));
    }

    @PatchMapping("/order/finish/{id}")
    public ResponseEntity<Order> finish(@PathVariable("id") Long orderId, Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.finish(orderId));
    }
    
    @PatchMapping("/order/accept/{id}")
    public ResponseEntity<Order> accept(@PathVariable("id") Long orderId, Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.accept(orderId));
    }

}
