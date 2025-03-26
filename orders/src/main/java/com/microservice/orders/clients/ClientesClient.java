package com.microservice.orders.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.commons.models.entity.Clientes;

@FeignClient(name = "microserviciosclientes")
public interface ClientesClient {
	
	@GetMapping("/{id}")
	public Optional <Clientes> getClientesById(@PathVariable Long id);
	

}
