package com.microservice.products.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
	@Id
	@SequenceGenerator(name = "productos_seq", sequenceName = "PRODUCTOS_SEQ", allocationSize = 1)
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;

    @Column(name = "NOMBRE", length = 50, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "PRECIO", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(name = "STOCK", nullable = false)
    private int stock;
}
