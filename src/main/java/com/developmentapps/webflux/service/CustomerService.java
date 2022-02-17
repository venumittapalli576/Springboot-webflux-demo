package com.developmentapps.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developmentapps.webflux.dao.CustomerDao;
import com.developmentapps.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	
	public List<Customer> retriveAll(){
		long start= System.currentTimeMillis();
		List<Customer> customers = customerDao.getCustomer();
		long end= System.currentTimeMillis();
		return customers;
	}
	
	
	public Flux<Customer> retriveAllReactive(){
		long start= System.currentTimeMillis();
		Flux<Customer> customers = customerDao.getCustomerReactive();
		long end= System.currentTimeMillis();
		return customers;
	}
}
