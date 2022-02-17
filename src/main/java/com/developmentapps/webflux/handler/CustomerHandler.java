package com.developmentapps.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.developmentapps.webflux.dao.CustomerDao;
import com.developmentapps.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

	@Autowired
	private CustomerDao customerDao;
	
	public Mono<ServerResponse> retriveAllHandler(ServerRequest serverRequest){
		Flux<Customer> customerHandler = customerDao.getCustomerHandler();
		return ServerResponse.ok().body(customerHandler,Customer.class);
	}
	
}
