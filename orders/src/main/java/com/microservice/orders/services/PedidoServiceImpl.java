package com.microservice.orders.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.commons.models.entity.Pedidos;
import com.ecommerce.commons.services.CommonServiceImpl;
import com.microservice.orders.dto.PedidosDTO;
import com.microservice.orders.mappers.PedidoMapper;
import com.microservice.orders.repositories.PedidoRepository;



@Service
public class PedidoServiceImpl extends CommonServiceImpl<Pedidos, PedidoRepository>
implements PedidoService{
	
	private final PedidoMapper mapper;
	
	public PedidoServiceImpl(PedidoMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Pedidos createPedidosDTO(PedidosDTO pedidoDTO) {
		Pedidos pedido = mapper.dtoToEntity(pedidoDTO);
		return repository.save(pedido);
	}
	
	@Override
	@Transactional
	public Pedidos update(PedidosDTO pedidoDTO,Long id) {
		Optional<Pedidos> optPedido = repository.findById(id);
		if(optPedido.isPresent()) {
			Pedidos pedidoDb= mapper.dtoToEntity(pedidoDTO);
			pedidoDb.setId(id);
			return repository.save(pedidoDb);
			}
		return null;
		
	}

}
