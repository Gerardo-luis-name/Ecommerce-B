package com.ecommerce.clientes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.clientes.service.ClienteService;
import com.ecommerce.commons.controllers.CommonController;
import com.ecommerce.commons.models.entity.Clientes;

import jakarta.validation.Valid;


@RestController
public class ClienteController extends CommonController<Clientes, ClienteService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Clientes cliente, 
			BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Clientes clienteDb = service.actualizar(cliente, id);
	if (clienteDb!=null) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
	}
	return ResponseEntity.notFound().build();

	}
}
