package com.HM.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta clase product se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una DB)
@Table(name = "product") // Especificamos el nombre de la tabla de mysql a donde llega esta informacion

public class Product {
	
	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estrategia de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	
	@Column(name = "IDPRODUCT", unique = true, nullable = false)
	private Integer idProduct;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "PRICE", nullable = false)
	private Double price;

	@Column(name = "STOCK", nullable = false)
	private Integer stock;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "COLOR", nullable = false)
	private String color;
	
	@Column(name = "SIZE", nullable = false)
	private String size;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@Column(name = "IMAGE", nullable = false)
	private String image;
	
	@Column(name = "FK_IDCATEGORYCLOTHE", nullable = false)
	private String fk_idCategoryClothe;
	
	@Column(name = "FK_IDADMIN", nullable = false)
	private String fk_idAdmin;
	
	public Product () {
		
	}

	public Product(Integer idProduct, String name, Double price, Integer stock, String description, String color, String size, String category, String image, String fk_idCategoryClothe, String fk_idAdmin) {
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.color = color;
		this.size = size;
		this.category = category;
		this.image = image;
		this.fk_idCategoryClothe = fk_idCategoryClothe;
		this.fk_idAdmin = fk_idAdmin;
	}

	public Integer getIdProduct() {
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
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFk_idCategoryClothe() {
		return fk_idCategoryClothe;
	}

	public void setFk_idCategoryClothe(String fk_idCategoryClothe) {
		this.fk_idCategoryClothe = fk_idCategoryClothe;
	}

	public String getFk_idAdmin() {
		return fk_idAdmin;
	}

	public void setFk_idAdmin(String fk_idAdmin) {
		this.fk_idAdmin = fk_idAdmin;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", color=" + color + ", size=" + size + ", category=" + category
				+ ", image=" + image + ", fk_idCategoryClothe=" + fk_idCategoryClothe + ", fk_idAdmin=" + fk_idAdmin
				+ "]";
	}

}
