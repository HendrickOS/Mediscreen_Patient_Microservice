package com.project9.Mediscreen_Patient_Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class MediscreenPatientMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediscreenPatientMicroserviceApplication.class, args);
	}

}
