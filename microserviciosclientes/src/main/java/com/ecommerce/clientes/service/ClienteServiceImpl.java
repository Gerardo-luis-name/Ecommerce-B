package com.ecommerce.clientes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.clientes.repository.ClienteRepository;
import com.ecommerce.commons.models.entity.Clientes;
import com.ecommerce.commons.services.CommonServiceImpl;



@Service
public class ClienteServiceImpl extends CommonServiceImpl<Clientes, ClienteRepository> implements ClienteService{
	
	@Override
	@Transactional
	public Clientes actualizar(Clientes cliente, Long id){
		Optional<Clientes> optCliente = repository.findById(id);
		if(optCliente.isPresent()) {
			Clientes clienteDb=optCliente.get();
			clienteDb.setNombre(cliente.getNombre());
			clienteDb.setApellido(cliente.getApellido());
			clienteDb.setEmail(cliente.getEmail());
			clienteDb.setDireccion(cliente.getDireccion());
			repository.save(clienteDb);
			return clienteDb;
		}
		return null;
	}

}
