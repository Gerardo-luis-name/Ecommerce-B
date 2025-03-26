package com.microservice.orders.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commons.controllers.CommonController;
import com.ecommerce.commons.models.entity.Pedidos;
import com.microservice.orders.dto.PedidosDTO;
import com.microservice.orders.services.PedidoService;

import jakarta.validation.Valid;

@RestController
public class PedidoController extends CommonController<Pedidos, PedidoService>{
	
	@PostMapping("/pedidos-dto")
	public ResponseEntity<?> create (@Valid @RequestBody PedidosDTO pedidosDTO,BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createPedidosDTO(pedidosDTO));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody PedidosDTO pedidosDTO,
			BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Pedidos pedidosDb = service.update(pedidosDTO, id);
		if(pedidosDTO != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidosDb);
		}
		return ResponseEntity.notFound().build();
		
	}

}
