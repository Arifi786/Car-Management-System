package com.example.CarManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@OpenAPIDefinition(info = @Info(
//		title = "Car Management API",
//		version = "1.0",
//		description = "API for managing cars, including CRUD operations, pagination, and search."
//))
@SpringBootApplication
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}

}
