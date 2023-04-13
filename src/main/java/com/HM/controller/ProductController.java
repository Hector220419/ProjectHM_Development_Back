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

import com.HM.model.Product;
import com.HM.service.ProductService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping (path = "/wm/product/")

public class ProductController {

	// Inyeccion de dependencias
	private final ProductService productService;
	
	@Autowired // Anotacion para relacionar e inyectar dependencia
	// Constructor que usa el objeto ProductService como parametro
	public ProductController (ProductService productService) {
		this.productService = productService;
	}
	
	// Solicitudes HTTP para traer todos los productos
	@GetMapping
	public List<Product> getProducts(){
		return productService.readProducts();
	}
	
	// Traer un producto por ID
	@GetMapping(path = "{IDPRODUCT}")
	
	// Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
	public Product getProduct(@PathVariable("IDPRODUCT") Integer idProduct) {
		return productService.readProduct(idProduct);
	}
	
/****************************** POST ******************************/
	
	// Solicitud HTTP POST para crear un producto
	@PostMapping
	public void postProduct(@RequestBody Product product) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
		productService.createProduct(product); // aqui disparo la operacion del crud que modifica la base de datos.
	}
	
	/****************************** UPDATE ******************************/
	
	// Solicitud HTTP PUT para modificar un producto
	
	@PutMapping(path = "{IDPRODUCT}")
	public void updateProduct(@PathVariable("IDPRODUCT")Integer idProduct, 
			@RequestParam (required = false) String name, 
			@RequestParam (required = false) Double price, 
			@RequestParam (required = false) Integer stock, 
			@RequestParam (required = false) String description,
			@RequestParam (required = false) String color,
			@RequestParam (required = false) String size,
			@RequestParam (required = false) String category,
			@RequestParam (required = false) String image,
			@RequestParam (required = false) String fk_idCategoryClothe,
			@RequestParam (required = false) String fk_idAdmin)
	{
		productService.updateProduct(idProduct,name, price, stock, description, color, size, category, image, fk_idCategoryClothe, fk_idAdmin);
	}
	
	/****************************** DELETE ******************************/
	
	// Solicitud HTTP DELETE para eliminar un producto
	
	
	@DeleteMapping(path = "{IDPRODUCT}")
	public void deleteProduct(@PathVariable("IDPRODUCT")Integer id) {
		productService.deleteProduct(id);
	}
	
	// GET Product (GET)
	
	// POST Product (POST)
	
	// PUT Product (PUT)
	
	// DELETE Product (DELETE)
	
}
