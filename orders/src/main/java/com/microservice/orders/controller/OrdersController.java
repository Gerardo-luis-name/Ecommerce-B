package com.microservice.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes")
public class OrdersController {

    @GetMapping("/prueba")
    public String holamundo(){
        return "Hola Este End Point es de Ordenes!";
    }
}
