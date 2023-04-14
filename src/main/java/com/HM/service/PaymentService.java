package com.HM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HM.model.Payment;
import com.HM.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	
	// Creo un cable para conectar entidades (ProductRepository - ProductService)
	@Autowired
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	/****************************** CREATE ******************************/
	// Crear payment(Create)
	public void createPayment(Payment payment) {
		paymentRepository.save(payment);
		// Si no existe, entonces lo guardamos en la base de datos
		
	}
	
	
	
	/****************************** READ ******************************/
	// Leer payment (Read)
	public List<Payment> readPayments() {
		return paymentRepository.findAll();
	}
	
	public Payment readPayment(Integer idPayment){
		 return paymentRepository.findById(idPayment).orElseThrow(()-> new IllegalStateException("The payment " + "with id " + idPayment + " does not exist.") );
	}
	
	
	
/****************************** UPDATE ******************************/
	
	// Actualizar producto (Update)
	
	//Necesitamos pasar todos los parametros, para contemplar todas las modificaciones posibles
	public void updatePayment(Integer idPayment, String paymentDate, Integer fk_idOrder) {		
		//Si el producto existe, entonces se modifica
		if (paymentRepository.existsById(idPayment)) {
			//entonces lo modifico
			
			//traigo el objeto, y lo pongo en la variable temporal
			Payment findPayment = paymentRepository.getById(idPayment);
			if (paymentDate!=null) findPayment.setPaymentDate(paymentDate);
			if (fk_idOrder!=null) findPayment.setFk_idOrder(fk_idOrder);
			
			//cuando termino de editar el objeto...
			paymentRepository.save(findPayment);
			//Si el producto NO existe, no puedo modificar nada y muestro un mensaje
		}else {
			System.out.println("The payment with id " + idPayment + " does not exist");
		}	
	}
	
	
	
/****************************** DELETE ******************************/
	
	//Borrar producto (Delete)
		public void deletePayment(Integer idPayment) {
			//Buscamos un producto por id, y si existe...
			if (paymentRepository.existsById(idPayment)) {//true
				//Lo borramos
				paymentRepository.deleteById(idPayment);
			}
		}
	
}
