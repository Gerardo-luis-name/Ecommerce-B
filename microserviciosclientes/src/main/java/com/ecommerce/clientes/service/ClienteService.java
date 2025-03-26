package com.ecommerce.clientes.service;

import com.ecommerce.commons.models.entity.Clientes;
import com.ecommerce.commons.services.CommonService;


public interface ClienteService extends CommonService<Clientes>{
	Clientes actualizar(Clientes cliente, Long id);
}
