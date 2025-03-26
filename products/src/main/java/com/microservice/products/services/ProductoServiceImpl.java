package com.microservice.products.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.commons.models.entity.Productos;
import com.ecommerce.commons.services.CommonServiceImpl;
import com.microservice.products.repository.ProductsRepository;

import jakarta.transaction.Transactional;



@Service
public class ProductoServiceImpl extends CommonServiceImpl<Productos, ProductsRepository> implements ProductoService {
    
    

	@Override
	@Transactional
	public Productos actualizar(Productos producto, long id) {
		Optional<Productos> optProducto = repository.findById(id);
        if(optProducto.isPresent()) {
            Productos productsDb = optProducto.get();
            productsDb.setNombre(producto.getNombre());
            productsDb.setDescripcion(producto.getDescripcion());
            productsDb.setPrecio(producto.getPrecio());
            productsDb.setStock(producto.getStock());
            repository.save(productsDb);
            return productsDb;
        }
		return null;
	}
}
