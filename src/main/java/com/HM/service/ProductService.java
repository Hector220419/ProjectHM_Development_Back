package com.HM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HM.model.Product;
import com.HM.repository.ProductRepository;

@Service

public class ProductService {

	//Que voy a relacionar, como lo voy a relacionar, cuando lo voy a utilizar
	// Primero declaro una varible del tipo PlatilloRepository para usarla cuando la necesite

	private final ProductRepository productRepository;

	// Creo un cable para conectar entidades (ProductRepository - ProductService)
	@Autowired

	// Uso ese objeto como parametro de mi constructor
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Logica de nuestro negocio

	// Operaciones del CRUD
	
	/****************************** CREATE ******************************/
	// Crear producto (Create)
	public void createProduct(Product product) {
		
		// Primero guardamos el dato en un optional
		// Si hay algo en ese Optional.isPresent nos regresa un true o un false
		
		// Necesitamos saber si el producto buscado existe
		Optional<Product> findProduct = productRepository.findByName(product.getName()); // Buscamos por nombre
		
		if(findProduct.isPresent()) {
			throw new IllegalStateException("The product names " + product.getName() + " is already exists");
		}
		else {
			productRepository.save(product);
		}
		// Si no existe, entonces lo guardamos en la base de datos
	}

	/****************************** READ ******************************/
	
	// Leer producto (Read)
	public List<Product> readProducts() {
		return productRepository.findAll();
	}
	
	public Product readProduct(Long idProduct){
		 return productRepository.findById(idProduct).orElseThrow(()-> new IllegalStateException("The product " + "with id " + idProduct + " does not exist.") );
	}
	
	/****************************** UPDATE ******************************/
	
	// Actualizar producto (Update)
	
	//Necesitamos pasar todos los parametros, para contemplar todas las modificaciones posibles
	public void updateProduct(Long idProduct, String name, Double price, Integer stock, String description, String color, String size, String image) {		
		//Si el producto existe, entonces se modifica
		if (productRepository.existsById(idProduct)) {
			//entonces lo modifico
			
			//traigo el objeto, y lo pongo en la variable temporal
			Product findProduct = productRepository.getById(idProduct);
			if (name!=null) findProduct.setName(name);
			if (price!=null) findProduct.setPrice(price);
			if (stock!=null) findProduct.setStock(stock);
			if (description!=null) findProduct.setDescription(description);
			if (color!=null) findProduct.setColor(color);
			if (size!=null) findProduct.setSize(size);
			if (image!=null) findProduct.setImage(image);
			
			//cuando termino de editar el objeto...
			productRepository.save(findProduct);
			//Si el producto NO existe, no puedo modificar nada y muestro un mensaje
		}else {
			System.out.println("The product with id " + idProduct + " does not exist");
		}	
	}
	
	/****************************** DELETE ******************************/
	
	//Borrar producto (Delete)
		public void deleteProduct(Long idProduct) {
			//Buscamos un producto por id, y si existe...
			if (productRepository.existsById(idProduct)) {//true
				//Lo borramos
				productRepository.deleteById(idProduct);
			}
		}
	
	// Actualizar producto (Update)
	// Borrar producto (Delete)
	
}
