package com.ecommerce.commons.models.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
		private LocalDate fechaCreacion;
		
		@Enumerated(EnumType.STRING)
		@Column(name = "ESTADO")
		@NotNull(message = "El estado del pedido es obligatoria")
		private EstadoPedido estadoPedido;
		
		@ManyToOne
		@JsonBackReference
	    @JoinColumn(name = "ID_CLIENTE", nullable = false)
	    private Clientes idCliente;
		
		@ManyToMany
	    @JoinTable(
	        name = "PEDIDOS_PRODUCTOS", 
	        joinColumns = @JoinColumn(name = "ID_PRODUCTO"), 
	        inverseJoinColumns = @JoinColumn(name = "ID_PEDIDO")
	    )
	    private List<Productos> productos;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public LocalDate getFechaCreacion() {
			return fechaCreacion;
		}



		public void setFechaCreacion(LocalDate fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}



		public EstadoPedido getEstadoPedido() {
			return estadoPedido;
		}



		public void setEstadoPedido(EstadoPedido estadoPedido) {
			this.estadoPedido = estadoPedido;
		}



		public Clientes getIdCliente() {
			return idCliente;
		}



		public void setIdCliente(Clientes idCliente) {
			this.idCliente = idCliente;
		}
		
		


		public List<Productos> getProductos() {
			return productos;
		}



		public void setProductos(List<Productos> productos) {
			this.productos = productos;
		}




		public enum EstadoPedido {
	        PENDIENTE,
	        ENVIADO,
	        ENTREGADO,
	        CANCELADO;
	    }
}