package com.example.myserviceresgistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyServiceResgistryApplication {

	public static void main(String[] args) {


		SpringApplication.run(MyServiceResgistryApplication.class, args);
	}

}
