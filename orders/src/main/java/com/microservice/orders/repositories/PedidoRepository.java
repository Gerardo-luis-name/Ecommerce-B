package com.microservice.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.commons.models.entity.Pedidos;

public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	

}
