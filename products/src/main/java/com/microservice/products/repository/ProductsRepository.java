package com.microservice.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.commons.models.entity.Productos;

public interface ProductsRepository extends JpaRepository<Productos, Long>{
	

}
