package com.HM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HM.model.Order;

import com.HM.service.OrderService;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping (path = "/wm/order/")

public class OrderController {
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		
		this.orderService = orderService;
	}
	
	// Solicitudes HTTP para traer todos las ordenes
		@GetMapping
		public List<Order> getProducts(){
			return orderService.readOrders();
		}
	
	// Traer un producto por ID GET
		@GetMapping(path = "{idOrder}")
		
		// Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
		public Order getProduct(@PathVariable("idOrder") Integer idOrder) {
			return orderService.readOrder(idOrder);
		}
		
		/****************************** POST ******************************/
		//para crear una orden
		// Solicitud HTTP POST para crear un producto
		@PostMapping
		public void postOrder(@RequestBody Order order) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
			orderService.createOrder(order); // aqui disparo la operacion del crud que modifica la base de datos.
		}
		/********************fin de post*/
		
		/************UPDATE**********************/
		//Solicitud HTTP PUT para modificar un platillo
		@PutMapping(path = "{idOrder}")
		
		public void updateOrder(@PathVariable("idOrder")Integer idOrder, 
				@RequestParam (required = false) String orderDate, 
				@RequestParam (required = false) Integer fk_idCustomer)
				{
			orderService.updateOrder(idOrder, orderDate, fk_idCustomer);
				}
		
		/****************************** DELETE ******************************/
		
		// Solicitud HTTP DELETE para eliminar un producto
		
		
		@DeleteMapping(path = "{idOrder}")
		public void deleteProduct(@PathVariable("idOrder")Integer idOrder) {
			orderService.deleteOrder(idOrder);
		}
	
}
