package com.HM.controller;

import java.util.Date;
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

import com.HM.model.OrderHasProduct;
import com.HM.service.OrderHasProductService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping (path = "/wm/order_has_product/")

public class OrderHasProductController {
	
	// Inyeccion de dependencias
	private final OrderHasProductService orderHasProductService;
			
	@Autowired // Anotacion para relacionar e inyectar dependencia
	// Constructor que usa el objeto ProductService como parametro
	public OrderHasProductController (OrderHasProductService orderHasProductService) {
		this.orderHasProductService = orderHasProductService;
	}
		
	// Solicitudes HTTP para traer todos los productos
	@GetMapping
	public List<OrderHasProduct> getOrderHasProducts(){
		return orderHasProductService.readOrderHasProducts();
	}
		
	// Traer un producto por ID
	@GetMapping(path = "{FK_IDORDER}")
			
	// Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
	public OrderHasProduct getOrderHasProduct(@PathVariable("FK_IDORDER") Integer fk_idOrder) {
		return orderHasProductService.readOrderHasProduct(fk_idOrder);
	}
	
	
	/****************************** POST ******************************/
	// Solicitud HTTP POST para crear un producto
	@PostMapping
	public void postOrderHasProduct(@RequestBody OrderHasProduct orderHasProduct) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
		orderHasProductService.createOrderHasProduct(orderHasProduct); // aqui disparo la operacion del crud que modifica la base de datos.
	}
	
	/****************************** UPDATE ******************************/
	// Solicitud HTTP PUT para modificar un producto
	
	@PutMapping(path = "{FK_IDORDER}")
	public void updateOrderHasProduct(@PathVariable("FK_IDORDER")int fk_idOrder, 
			@RequestParam (required = false) int fk_idProduct, 
			@RequestParam (required = false) int quantity)
	{
		orderHasProductService.updateOrderHasProduct(fk_idProduct, quantity);
	}
	
	
	/****************************** DELETE ******************************/
	// Solicitud HTTP DELETE para eliminar un producto
	
	
	@DeleteMapping(path = "{FK_IDORDER}")
	public void deleteOrderHasProduct(@PathVariable("FK_IDORDER")Integer id) {
		orderHasProductService.deleteOrderHasProduct(id);
	}
	
	
}
