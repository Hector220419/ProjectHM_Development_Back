package com.HM.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta clase product se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una DB)
@Table(name = "Product") // Especificamos el nombre de la tabla de mysql a donde llega esta informacion

public class Product {
	
	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estrategia de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	
	@Column(name = "idproduct", unique = true, nullable = false)
	private Long idProduct;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "size", nullable = false)
	private String size;
	
	@Column(name = "image", nullable = false)
	private String image;
	
	public Product () {
		
	}

	public Product(Long idProduct, String name, Double price, Integer stock, String description, String color, String size, String image) {
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.color = color;
		this.size = size;
		this.image = image;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", color=" + color + ", size=" + size + ", image=" + image + "]";
	}

}
