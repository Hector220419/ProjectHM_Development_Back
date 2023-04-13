package com.HM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HM.model.OrderHasProduct;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, Integer>{
@Query(value="SELECT p FROM order_has_product p WHERE fk_idOrder = ?1", nativeQuery=true) // Se utiliza el primer parametro encontrado
	
	// Metodo que realiza la consulta personalizada definida anteriormente. Retorna un optional que puede contener un objeto Product si se encuentra en la base de datos (tiene que ser con el nombre especificado), o un optional vacio si no existe.
	
	Optional<OrderHasProduct> findById(Integer fk_idOrder);
}
