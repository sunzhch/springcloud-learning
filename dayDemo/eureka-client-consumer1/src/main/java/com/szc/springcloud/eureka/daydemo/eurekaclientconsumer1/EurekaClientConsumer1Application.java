package com.szc.springcloud.eureka.daydemo.eurekaclientconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaClientConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientConsumer1Application.class, args);
	}
}
