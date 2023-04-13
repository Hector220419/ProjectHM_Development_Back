package com.HM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta clase product se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una DB)
@Table(name = "CATEGORYCLOTHE") // Especificamos el nombre de la tabla de mysql a donde llega esta informacion

public class CategoryClothe {
	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estrategia de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	
	@Column(name = "IDCATEGORYCLOTHE", unique = true, nullable = false)
	private Integer idCategoryClothe;
	
	@Column(name = "NAMECATEGORY", nullable = false)
	private String nameCategory;

	public CategoryClothe() {
		
	}
	
	public CategoryClothe(Integer idCategoryClothe, String name) {
		this.idCategoryClothe = idCategoryClothe;
		this.nameCategory = name;
	}

	public Integer getIdCategoryClothe() {
		return idCategoryClothe;
	}
	
	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String name) {
		this.nameCategory = name;
	}

	@Override
	public String toString() {
		return "CategoryClothe [idCategoryClothe=" + idCategoryClothe + ", name=" + nameCategory + "]";
	}
	
}