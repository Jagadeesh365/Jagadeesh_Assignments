package com.room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.room.model.Room;
import com.room.model.RoomType;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class RoomManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomManagementServiceApplication.class, args);
	}
	
	@Bean
	public Room getRoomTypeInventoryObject() {
		return new Room();
	}
	@Bean
	public RoomType getRoomInventoryObject() {
		return new RoomType();
	}
	//logger bean
	@Bean
	public Logger getLogger() {
		return LoggerFactory.getLogger(RoomManagementServiceApplication.class);
	}
}
