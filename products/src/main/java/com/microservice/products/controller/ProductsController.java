package com.microservice.products.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commons.controllers.CommonController;
import com.ecommerce.commons.models.entity.Productos;
import com.microservice.products.services.ProductoService;

import jakarta.validation.Valid;

@RestController
public class ProductsController  extends CommonController<Productos, ProductoService > {
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Productos producto,
			BindingResult result, @PathVariable Long id){
		if(result.hasErrors()){
			return this.validar(result);
			
		}
		Productos productsDb = service.actualizar(producto, id);
	if(productsDb!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(productsDb);
			
		}
		return ResponseEntity.notFound().build();
		
	}
}
		