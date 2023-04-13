package com.HM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta clase product se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una DB)
@Table(name = "ADMIN") // Especificamos el nombre de la tabla de mysql a donde llega esta informacion

public class Admin {
	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estrategia de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	
	@Column(name = "IDADMIN", unique = true, nullable = false)
	private Integer idAdmin;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	public Admin() {
		
	}
	
	public Admin(Integer idAdmin, String email, String password) {
		this.idAdmin = idAdmin;
		this.email = email;
		this.password = password;
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", email=" + email + ", password=" + password + "]";
	}
	
}
