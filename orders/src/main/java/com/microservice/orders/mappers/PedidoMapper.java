package com.microservice.orders.mappers;


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
        pedidosDTO.setIdCliente(pedidos.getIdClientes() != null ? pedidos.getIdClientes().getId() : null);
	    return pedidosDTO;
	}
	
	public Pedidos dtoToEntity(PedidosDTO pedidosDTO) {
		
		if(pedidosDTO == null) {
			return null;
		}
		
		Pedidos pedido = new Pedidos();
		pedido.setId(pedidosDTO.getId());
		pedido.setTotal(pedidosDTO.getTotal());
		pedido.setFechaCreacion(pedidosDTO.getFechacreacion());
		
		if (pedidosDTO.getIdCliente() != null) {
            Clientes cliente = new Clientes();
            cliente.setId(pedidosDTO.getIdCliente()); // Asignar solo el ID
            pedido.setIdClientes(cliente);
        }
		return pedido;
	}

}
