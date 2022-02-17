package com.developmentapps.webflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.developmentapps.webflux.handler.CustomerHandler;
import com.developmentapps.webflux.handler.CustomerReactiveHandler;

@Configuration
public class RouterConfig {

	@Autowired
	private CustomerHandler customerHandler;

	@Autowired
	private CustomerReactiveHandler customerReactiveHandler;
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route()
				.GET("/router/customerdetails", customerHandler::retriveAllHandler)
				.GET("/router/customerdetailsReactive", customerReactiveHandler::retriveAllHandlerReactive)
				.GET("/router/customerdetailsReactive/{input}", customerReactiveHandler::findCustomerHandlerReactive)
				.POST("/router/customerdetailsReactive/save",customerReactiveHandler::saveCustomerHandlerReactive)
				.build();
	}
}
