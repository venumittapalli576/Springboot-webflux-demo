package com.developmentapps.webflux.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developmentapps.webflux.dto.Customer;
import com.developmentapps.webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerServie;
	
	
	@GetMapping("/retriveAll")
	public List<Customer> retriveall() {
		return customerServie.retriveAll();
	}
	
	@GetMapping(value = "/retriveAllReactive" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> retriveAllReactive() {
		return customerServie.retriveAllReactive();
	}
}
