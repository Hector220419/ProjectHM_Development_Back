package com.HM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //establecer que esta clase se convierte en una entidad jpa
@Table(name="CLOTHEORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "idOrder", unique = true, nullable = false)
	
	
	//atributos
	@Column(name = "IDORDER", unique = true, nullable = false)
	private Integer idOrder;
	
	@Column(name = "ORDERDATE", nullable = false)
	private String orderDate;
	
	@Column(name = "FK_IDCUSTOMER", nullable = false)
	private Integer fk_idCustomer;

	public Order() {
		
	}

	public Order(Integer idOrder, String orderDate, Integer fk_idCustomer) {
		this.idOrder = idOrder;
		this.orderDate = orderDate;
		this.fk_idCustomer = fk_idCustomer;
	}

	public Integer getIdOrder() {
		return idOrder;
	}
	
	/*
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	*/

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getFk_idCustomer() {
		return fk_idCustomer;
	}

	public void setFk_idCustomer(Integer fk_idCustomer) {
		this.fk_idCustomer = fk_idCustomer;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", orderDate=" + orderDate + ", fk_idCustomer=" + fk_idCustomer + "]";
	}
	
	
	
	
	
}
