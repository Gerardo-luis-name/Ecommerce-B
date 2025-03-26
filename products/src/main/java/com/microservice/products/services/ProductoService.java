package com.microservice.products.services;

import com.ecommerce.commons.models.entity.Productos;
import com.ecommerce.commons.services.CommonService;



public interface ProductoService extends CommonService<Productos>{
	
		Productos actualizar(Productos producto, long id); 

}
