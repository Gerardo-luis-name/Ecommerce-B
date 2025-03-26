package com.microservice.orders.dto;

import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class PedidosDTO {
	
	private Long id;
	
	@NotNull(message = "El total es obligatorio")
	@Min(value = 200, message = "El total de pedidos debe ser al menos 200")
	private Long total;
	
	@NotNull(message = "La fecha de creacion es obligatorio")
	@Past(message = "La fecha de creacion debe ser anterior a la fecha actual")
	private LocalDate fechacreacion;
	
	@NotNull(message = "El estado del pedido es obligatorio")
    @Enumerated(EnumType.STRING)
	private String estadoPedido;
	
	@NotNull(message = "El id del cliente no puede ser nulo")
	@Min(value = 1, message = "El Id del cliente de puede ser menor que 1")
	private Long idCliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public LocalDate getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
	

}
