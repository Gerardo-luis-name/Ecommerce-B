package com.ecommerce.commons.models.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "CLIENTES")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_SEQ")
	@SequenceGenerator(name = "CLIENTES_SEQ", sequenceName = "CLIENTES_SEQ", allocationSize = 1)
	@Column(name = "ID_CLIENTE")
	private Long id;
	
	@Column(name = "NOMBRE")
	@NotBlank(message = "El nombre del cliente es obligatorio")
	@Size(min = 1, max = 50, message = "El nombre del cliente debe tener entre 1 a 50 caracteres")
	private String nombre;
	
	@Column(name = "APELLIDO")
	@NotBlank(message = "El apellido del cliente es obligatorio")
	@Size(min = 1, max = 50, message = "El apellido del cliente debe tener entre 1 a 50 caracteres")
	private String apellido;
	
	@Column(name = "EMAIL")
	@NotBlank(message = "El correo del cliente es obligatorio")
	@Size(min = 1, max = 50, message = "El correo del cliente debe tener entre 1 a 50 caracteres")
	private String email;
	
	@Column(name = "TELEFONO")
	@NotNull(message = "El correo del cliente es obligatorio")
	@Max(value = 9999999999L, message = "El numero del cliente no debe ser mayor a 10 digitos")
	private Long telefono;
	
	@Column(name = "DIRECCION")
	@NotBlank(message = "La direccion del cliente es obligatorio")
	@Size(min = 10, max = 100, message = "La direccion del cliente debe tener entre 10 a 100 caracteres")
	private String direccion;
	
	
	//@OneToMany(mappedBy = "idCliente")
    //private List<Pedidos> pedidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	
	
}
