package com.m1fonda.service_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceNotificationApplication.class, args);
	}

}
