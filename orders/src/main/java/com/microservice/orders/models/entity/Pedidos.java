package com.microservice.orders.models.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "PEDIDOS")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDOS_SEQ")
	@SequenceGenerator(name = "PEDIDOS_SEQ", sequenceName = "PEDIDOS_SEQ", allocationSize = 1)
	@Column(name = "ID_PEDIDO")
	private Long id;
	
	@Column(name = "TOTAL")
	@NotBlank(message = "El total de los productos es obligatorio")
	@Size(min = 1, max = 50, message = "El nombre del producto debe tener entre 1 a 50 caracteres")
	private Long total;
	
	@Column(name = "FECHA_CREACION")
	@NotNull(message = "La fecha de fundacion es obligatoria")
	@Past(message = "La fecha de la fundacion debe ser anterior a la fecha actual")
	private LocalDate fechacreacion;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO")
	@NotNull(message = "El estado del pedido es obligatoria")
	private String estadoPedido;
	
	@NotNull(message = "El cliente es obligatorio")
	@JsonIgnoreProperties(value= {"handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
	private Clientes idCliente;

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

	public Clientes getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Clientes idCliente) {
		this.idCliente = idCliente;
	}
	

}
