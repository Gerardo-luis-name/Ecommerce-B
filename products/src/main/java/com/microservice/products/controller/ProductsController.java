package com.microservice.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductsController {

    @GetMapping("/prueba")
    public String holamundo(){
        return "Hola Este End Point es de Productos!";
    }
}
