package com.microservice.orders.mappers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.commons.models.entity.Clientes;
import com.ecommerce.commons.models.entity.Pedidos;
import com.microservice.orders.clients.ClientesClient;
import com.microservice.orders.dto.PedidosDTO;

@Component
public class PedidoMapper {
	
	@Autowired
	private ClientesClient clientesCliente;
	
	public  PedidosDTO entityToDto(Pedidos pedidos) {
		if(pedidos == null) {
			return null;
		}
		PedidosDTO pedidosDTO = new PedidosDTO();
		pedidosDTO.setId(pedidos.getId());
		pedidosDTO.setTotal(pedidos.getTotal());
		pedidosDTO.setFechacreacion(pedidos.getFechaCreacion());
	    pedidosDTO.setEstadoPedido(pedidos.getEstadoPedido());
	    if (pedidos.getClientes() != null && !pedidos.getClientes().isEmpty()) {
	        pedidosDTO.setIdCliente(pedidos.getClientes().get(0).getId()); 
	    } else {
	        pedidosDTO.setIdCliente(null); 
	    }
		
		return pedidosDTO;
		
	}
	
	@SuppressWarnings("unchecked")
	public Pedidos dtoToEntity(PedidosDTO pedidosDTO) {
		
		if(pedidosDTO == null) {
			return null;
		}
		
		Pedidos pedido = new Pedidos();
		pedido.setId(pedidosDTO.getId());
		pedido.setTotal(pedidosDTO.getTotal());
		pedido.setFechaCreacion(pedidosDTO.getFechacreacion());
		
		Optional<Clientes> cliente = clientesCliente.getClientesById(pedidosDTO.getIdCliente());
		pedido.setClientes(cliente.isPresent() ? (List<Clientes>) cliente.get() : null);
		return pedido;
	}

}
