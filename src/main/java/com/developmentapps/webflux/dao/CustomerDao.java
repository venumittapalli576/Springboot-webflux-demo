package com.developmentapps.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.developmentapps.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
	
	private static void sleepExecution(int o) {
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			e.getMessage();
		}
	}

	public List<Customer> getCustomer() {
		return IntStream.rangeClosed(1, 50)
				.peek(CustomerDao::sleepExecution)
				.peek(i -> System.out.println("processing count : " + i))
				.mapToObj(i -> new Customer(i, "customer" + i)).collect(Collectors.toList());

	}

	
	public Flux<Customer> getCustomerReactive() {
		return Flux.range(1, 50)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("processing count : " + i))
				.map(i -> new Customer(i, "customer" + i));

	}
	
	public Flux<Customer> getCustomerHandler() {
		return Flux.range(1, 50)
				.doOnNext(i -> System.out.println("processing count : " + i))
				.map(i -> new Customer(i, "customer" + i));

	}
}
