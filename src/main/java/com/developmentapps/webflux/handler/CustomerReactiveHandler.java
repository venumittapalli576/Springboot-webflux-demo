package com.developmentapps.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.developmentapps.webflux.dao.CustomerDao;
import com.developmentapps.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerReactiveHandler {

	@Autowired
	private CustomerDao customerDao;
	
	public Mono<ServerResponse> retriveAllHandlerReactive(ServerRequest serverRequest){
		Flux<Customer> customerHandler = customerDao.getCustomerHandler();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customerHandler,Customer.class);
	}
	
	
	public Mono<ServerResponse> findCustomerHandlerReactive(ServerRequest serverRequest){
		int customerId = Integer.valueOf(serverRequest.pathVariable("input"));
		Mono<Customer> customerMonoHandler = customerDao.getCustomerHandler().filter(c -> c.getId()==customerId).next();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customerMonoHandler,Customer.class);
	}
	
	
	
	public Mono<ServerResponse> saveCustomerHandlerReactive(ServerRequest serverRequest){
		Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);
		Mono<Object> saveResponse = customerMono.map(dto -> dto.getId() + ":" + dto.getName());
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(saveResponse,String.class);
	}
}
