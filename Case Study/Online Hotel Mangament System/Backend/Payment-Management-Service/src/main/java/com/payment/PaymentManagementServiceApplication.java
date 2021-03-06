package com.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class PaymentManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentManagementServiceApplication.class, args);
	}
	
	@Bean
	public Logger getLogger()
	{
		return LoggerFactory.getLogger(PaymentManagementServiceApplication.class);
	}
}
