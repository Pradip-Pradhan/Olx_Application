package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
//@EnableZuulProxy
public class GatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserviceApplication.class, args);
		System.out.println("------------------------------------");
	}
	
//	@Bean
//	public CoustomFilter coustomFilter() {
//		return new CoustomFilter();
//	}

}
