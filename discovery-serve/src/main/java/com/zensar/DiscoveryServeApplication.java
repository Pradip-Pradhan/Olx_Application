package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServeApplication.class, args);
	}
	
	/*

	{
		"couponCode":"toomuch",
		"discount":"2500",
		"expDate":"30/05/2022"
	}
	{
		"productName":"sumsung",
		"discription":"smart",
		"price":50000,
		"couponCode":"toomuch"
	}

 */

}
