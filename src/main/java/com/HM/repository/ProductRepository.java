package com.HM.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HM.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE name = ?1") // Se utiliza el primer parametro encontrado
	
	// Metodo que realiza la consulta personalizada definida anteriormente. Retorna un optional que puede contener un objeto Product si se encuentra en la base de datos (tiene que ser con el nombre especificado), o un optional vacio si no existe.
	
	Optional<Product> findByName(String name);
	
}
