package com.microservice.orders.services;


import com.ecommerce.commons.models.entity.Pedidos;
import com.ecommerce.commons.services.CommonService;
import com.microservice.orders.dto.PedidosDTO;

public interface PedidoService extends CommonService<Pedidos> {
		
	Pedidos update (PedidosDTO pedidosDTO, Long id);
	
	Pedidos createPedidosDTO (PedidosDTO pedidosDTO);

}
