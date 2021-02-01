package com.nl.fos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nl.fos.model.Customer;
import com.nl.fos.repository.CustomerRepository;
import com.nl.fos.repository.OrderRepository;
import com.nl.fos.service.CustomerService;

@Service
public class CustomerSericeImpl implements CustomerService {
	
	@Autowired
	 CustomerRepository customerRepository;
	
	
	Customer findByUsername(String username) {
		
		return customerRepository.findByUsername(username).get();
		
	}

}
