package com.HM.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta clase product se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una DB)
@Table(name = "PAYMENT") // Especificamos el nombre de la tabla de mysql a donde llega esta informacion

public class Payment {
	
	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estrategia de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	
	@Column(name = "IDPAYMENT", unique = true, nullable = false)
	private Integer idPayment;
	
	@Column(name = "PAYMENTDATE", unique = true, nullable = false)
	private String paymentDate;
	
	@Column(name = "FK_IDORDER", unique = true, nullable = false)
	private Integer fk_idOrder;
	
	public Payment () {
		
	}

	public Payment(int idPayment, String paymentDate, Integer fk_idOrder) {
		this.idPayment = idPayment;
		this.paymentDate = paymentDate;
		this.fk_idOrder = fk_idOrder;
	}

	public int getIdPayment() {
		return idPayment;
	}

	/*public void setIdPayment(Long idPayment) {
		this.idPayment = idPayment;
	}*/

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getFk_idOrder() {
		return fk_idOrder;
	}

	public void setFk_idOrder(Integer fk_idOrder) {
		this.fk_idOrder = fk_idOrder;
	}

	@Override
	public String toString() {
		return "Payment [idPayment=" + idPayment + ", paymentDate=" + paymentDate + ", fk_idOrder=" + fk_idOrder + "]";
	}
	
	
	
	
	
	
}

