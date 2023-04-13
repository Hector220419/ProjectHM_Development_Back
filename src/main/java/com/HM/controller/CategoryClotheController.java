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

import com.HM.model.CategoryClothe;
import com.HM.service.CategoryClotheService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping (path = "/wm/categoryClothe/")

public class CategoryClotheController {
	// Inyeccion de dependencias
	private final CategoryClotheService categoryClotheService;
	
	@Autowired // Anotacion para relacionar e inyectar dependencia
	// Constructor que usa el objeto CategoryClotheService como parametro
	public CategoryClotheController (CategoryClotheService categoryClotheService) {
		this.categoryClotheService = categoryClotheService;
	}
	
	// Solicitudes HTTP para traer todos los category clothe
	@GetMapping
	public List<CategoryClothe> getCategoryClothes(){
		return categoryClotheService.readCategoryClothes();
	}
	
	// Traer un category clothe por ID
	@GetMapping(path = "{idCategoryClothe}")
	
	// Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
	public CategoryClothe getCategoryClothe(@PathVariable("idCategoryClothe") Integer idCategoryClothe) {
		return categoryClotheService.readCategoryClothe(idCategoryClothe);
	}
	
/****************************** POST ******************************/
	
	// Solicitud HTTP POST para crear un category clothe
	@PostMapping
	public void postCategoryClothe(@RequestBody CategoryClothe categoryClothe) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
		categoryClotheService.createCategoryClothe(categoryClothe); // aqui disparo la operacion del crud que modifica la base de datos.
	}
	
	/****************************** UPDATE ******************************/
	
	// Solicitud HTTP PUT para modificar un category clothe
	
	@PutMapping(path = "{iCategoryClothe}")
	public void updateAdmin(@PathVariable ("iCategoryClothe") Integer iCategoryClothe, 
			@RequestParam (required = false) String nameCategory)
	{
		categoryClotheService.updateCategoryClothe(iCategoryClothe, nameCategory);
	}
	
	/****************************** DELETE ******************************/
	
	// Solicitud HTTP DELETE para eliminar un category clothe
	
	
	@DeleteMapping(path = "{idCategoryClothe}")
	public void deleteCategoryClothe(@PathVariable("idCategoryClothe")Integer idCategoryClothe) {
		categoryClotheService.deleteCategoryClothe(idCategoryClothe);
	}
	
	// GET CategoryClothe (GET)
	
	// POST CategoryClothe (POST)
	
	// PUT CategoryClothe (PUT)
	
	// DELETE CategoryClothe (DELETE)
}
