package com.ecommerce.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.ecommerce.commons.models.entity"})
public class MicroserviciosclientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosclientesApplication.class, args);
	}

}
