package com.microservice.products.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCreateDTO {
	  private String nombre;
	    private String descripcion;
	    private BigDecimal precio;
	    private int stock;
}
