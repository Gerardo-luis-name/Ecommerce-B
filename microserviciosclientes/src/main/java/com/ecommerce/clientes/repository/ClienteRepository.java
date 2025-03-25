package com.ecommerce.clientes.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.commons.models.entity.Clientes;



public interface ClienteRepository extends JpaRepository<Clientes,Long>{

}
