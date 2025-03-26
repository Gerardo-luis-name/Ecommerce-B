package com.microservice.products.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.products.dto.ProductDTO;
import com.microservice.products.entity.Products;

@RestController
@RequestMapping("/productos")
public class ProductsController {

	@GetMapping("/prueba")
    public String holamundo(){
        return "Hola Este End Point es de Productos!";
    }
    
    @PostMapping("/create")
    public ResponseEntity<Products> crearProducto (@RequestBody ProductDTO productDTO){
    	Products product = productService.crearProducto(productDTO);
    	return new ResponseEntity<>(product,HttpStatus.CREATED);
    }	
 
}
