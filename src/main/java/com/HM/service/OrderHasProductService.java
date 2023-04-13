package com.HM.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HM.model.OrderHasProduct;

import com.HM.repository.OrderHasProductRepository;

@Service
public class OrderHasProductService {
	
	private final OrderHasProductRepository orderHasProductRepository;
	
	// Creo un cable para conectar entidades (ProductRepository - ProductService)
	@Autowired
		
	public OrderHasProductService(OrderHasProductRepository orderHasProductRepository) {
		this.orderHasProductRepository = orderHasProductRepository;
	}
	
	
	/****************************** CREATE ******************************/
	// Crear payment(Create)
	public void createOrderHasProduct(OrderHasProduct orderHasProduct) {
		
		// Primero guardamos el dato en un optional
		// Si hay algo en ese Optional.isPresent nos regresa un true o un false
		
		// Necesitamos saber si el producto buscado existe
		Optional<OrderHasProduct> findOrderHasProduct = orderHasProductRepository.findById(orderHasProduct.getFk_idOrder()); // Buscamos por nombre
		
		if(findOrderHasProduct.isPresent()) {
			throw new IllegalStateException("The order id" + orderHasProduct.getFk_idOrder() + "  already exists");
		}
		else {
			orderHasProductRepository.save(orderHasProduct);
		}
		// Si no existe, entonces lo guardamos en la base de datos
		
	}
	
	
	/****************************** READ ******************************/
	// Leer payment (Read)
	public List<OrderHasProduct> readOrderHasProducts() {
		return orderHasProductRepository.findAll();
	}
	
	public OrderHasProduct readOrderHasProduct(Integer fk_idOrder){
		 return orderHasProductRepository.findById(fk_idOrder).orElseThrow(()-> new IllegalStateException("The order " + "with id " + fk_idOrder + " does not exist.") );
	}
	
	
/****************************** UPDATE ******************************/
	
	// Actualizar producto (Update)
	
	//Necesitamos pasar todos los parametros, para contemplar todas las modificaciones posibles
	public void updateOrderHasProduct(Integer fk_idOrder, Integer fk_idProduct, Integer quantity) {		
		//Si el producto existe, entonces se modifica
		if (orderHasProductRepository.existsById(fk_idOrder)) {
			//entonces lo modifico
			
			//traigo el objeto, y lo pongo en la variable temporal
			OrderHasProduct findOrderHasProduct = orderHasProductRepository.getById(fk_idOrder);
			if (fk_idProduct!=null) findOrderHasProduct.setFk_idProduct(fk_idProduct);
			if (quantity!=null) findOrderHasProduct.setQuantity(quantity);
			
			//cuando termino de editar el objeto...
			orderHasProductRepository.save(findOrderHasProduct);
			//Si el producto NO existe, no puedo modificar nada y muestro un mensaje
		}else {
			System.out.println("The order with id " + fk_idOrder + " does not exist");
		}	
	}
	
	
/****************************** DELETE ******************************/
	
	//Borrar producto (Delete)
		public void deleteOrderHasProduct(Integer fk_idOrder) {
			//Buscamos un producto por id, y si existe...
			if (orderHasProductRepository.existsById(fk_idOrder)) {//true
				//Lo borramos
				orderHasProductRepository.deleteById(fk_idOrder);
			}
		}



public void updateOrderHasProduct(Integer fk_idProduct, Integer quantity) {
	// TODO Auto-generated method stub
	
}
	
}
