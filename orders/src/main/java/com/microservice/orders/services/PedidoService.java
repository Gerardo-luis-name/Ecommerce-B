package com.microservice.orders.services;

import java.util.List;
import java.util.Optional;

import com.microservice.orders.dto.PedidosDTO;

public interface PedidoService<E, Pedidos> {
	
	List<E> listar();
	Optional <E> obtenerPorId(Long id);
	E crear (E entity);
	Optional<E> eliminarPorId(Long id);
	
	Pedidos update (PedidosDTO pedidosDTO, Long id);
	
	Pedidos createAvionDTO (PedidosDTO pedidosDTO);

}
