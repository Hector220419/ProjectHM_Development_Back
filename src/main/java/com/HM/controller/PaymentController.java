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

import com.HM.model.Payment;
import com.HM.service.PaymentService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping (path = "/wm/payment/")

public class PaymentController {
	
	// Inyeccion de dependencias
	private final PaymentService paymentService;
		
	@Autowired // Anotacion para relacionar e inyectar dependencia
	// Constructor que usa el objeto ProductService como parametro
	public PaymentController (PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	// Solicitudes HTTP para traer todos los productos
	@GetMapping
	public List<Payment> getPayments(){
		return paymentService.readPayments();
	}
	
	// Traer un producto por ID
	@GetMapping(path = "{IDPAYMENT}")
		
	// Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
	public Payment getPayment(@PathVariable("IDPAYMENT") Integer idPayment) {
		return paymentService.readPayment(idPayment);
	}
	
	
/****************************** POST ******************************/
	// Solicitud HTTP POST para crear un producto
	@PostMapping
	public void postPayment(@RequestBody Payment payment) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
		paymentService.createPayment(payment); // aqui disparo la operacion del crud que modifica la base de datos.
	}
	
	
	/****************************** UPDATE ******************************/
	// Solicitud HTTP PUT para modificar un producto
	
	@PutMapping(path = "{IDPAYMENT}")
	public void updatePayment(@PathVariable("IDPAYMENT")Integer idPayment, 
			@RequestParam (required = false) String paymentDate, 
			@RequestParam (required = false) Integer fk_idOrder)
	{
		paymentService.updatePayment(idPayment,paymentDate, fk_idOrder);
	}
	
	
	/****************************** DELETE ******************************/
	// Solicitud HTTP DELETE para eliminar un producto
	
	
	@DeleteMapping(path = "{IDPAYMENT}")
	public void deletePayment(@PathVariable("IDPAYMENT")Integer idPayment) {
		paymentService.deletePayment(idPayment);
	}
}
