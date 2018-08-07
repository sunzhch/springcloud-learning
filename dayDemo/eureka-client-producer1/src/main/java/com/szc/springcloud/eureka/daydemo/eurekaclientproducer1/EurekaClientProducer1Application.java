package com.szc.springcloud.eureka.daydemo.eurekaclientproducer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientProducer1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProducer1Application.class, args);
	}
}
