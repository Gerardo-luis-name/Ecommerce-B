package com.microservice.clients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @GetMapping("/prueba")
    public String holamundo(){
        return "Hola Este End Point es de Clientes!";
    }
}
