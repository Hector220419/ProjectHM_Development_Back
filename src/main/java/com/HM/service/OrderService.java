package com.HM.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.HM.model.Order;

import com.HM.repository.OrderRepository;


@Service
public class OrderService {
	public final OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	//******CREAR ORDER******
		public void createOrder(Order order) {
			orderRepository.save(order);
			
		}
		
	//******LEER order******
		//lee todas las ordenes
	public List<Order> readOrders() {
		return orderRepository.findAll();
	}
		
	//lee una sola orden con el id
	public Order readOrder(Integer idOrder){
		return orderRepository.findById(idOrder).orElseThrow(()-> new IllegalStateException("The order " + "with id " + idOrder + " does not exist.") );
	}
	
	/****************************** UPDATE ******************************/
	
	// Actualizar order (Update)
	
	//Necesitamos pasar todos los parametros, para contemplar todas las modificaciones posibles
	public void updateOrder(Integer idOrder, String orderDate, Integer fk_idCustomer) {		
		//Si el producto existe, entonces se modifica
		if (orderRepository.existsById(idOrder)) {
			//entonces lo modifico
			
			//traigo el objeto, y lo pongo en la variable temporal
			Order findOrder = orderRepository.getById(idOrder);
			//System.out.println("estoy aqui"+findOrder.toString());
			if (orderDate!=null) findOrder.setOrderDate(orderDate);
			if (fk_idCustomer!=null) findOrder.setFk_idCustomer(fk_idCustomer);
				//System.out.println("estoy aqui customer"+findOrder.toString()); 
			
		
			
			//cuando termino de editar el objeto...
			orderRepository.save(findOrder);
			//Si el producto NO existe, no puedo modificar nada y muestro un mensaje
		}else {
			System.out.println("The product with id " + idOrder + " does not exist");
		}	
	}
	
/****************************** DELETE ******************************/
	
	//Borrar producto (Delete)
		public void deleteOrder(Integer idOrder) {
			//Buscamos un producto por id, y si existe...
			if (orderRepository.existsById(idOrder)) {//true
				//Lo borramos
				orderRepository.deleteById(idOrder);
			}
		}
	
	
	
}
