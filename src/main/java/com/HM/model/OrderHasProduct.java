package com.HM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta clase product se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una DB)
@Table(name = "ORDERHASPRODUCT") // Especificamos el nombre de la tabla de mysql a donde llega esta informacion

public class OrderHasProduct {

	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estrategia de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	
	@Column(name = "FK_IDORDER", unique = true, nullable = false)
	private Integer fk_idOrder;
	
	@Column(name = "FK_IDPRODUCT", nullable = false)
	private Integer fk_idProduct;
	
	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;
	
	public OrderHasProduct() {
		
	}

	public OrderHasProduct(Integer fk_idOrder, Integer fk_idProduct, Integer quantity) {
		this.fk_idOrder = fk_idOrder;
		this.fk_idProduct = fk_idProduct;
		this.quantity = quantity;
	}

	public Integer getFk_idOrder() {
		return fk_idOrder;
	}

	public void setFk_idOrder(Integer fk_idOrder) {
		this.fk_idOrder = fk_idOrder;
	}

	public Integer getFk_idProduct() {
		return fk_idProduct;
	}

	public void setFk_idProduct(Integer fk_idProduct) {
		this.fk_idProduct = fk_idProduct;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderHasProduct [fk_idOrder=" + fk_idOrder + ", fk_idProduct=" + fk_idProduct + ", quantity=" + quantity
				+ "]";
	}
	
	
	
	
}
