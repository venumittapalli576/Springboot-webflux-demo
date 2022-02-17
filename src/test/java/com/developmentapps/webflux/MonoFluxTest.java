package com.developmentapps.webflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

	@Test
	public void testMono() {
		Mono<String> monoString = Mono.just("venu").log();
		monoString.subscribe(System.out::println);
	}
	
	@Test
	public void testFlux() {
		Flux<String> fluxs = Flux.just("spring", "venu", "reactive Programming")
				.concatWithValues("Mittapalli")
				.log();
		
		fluxs.subscribe(System.out::println);
	}
}
