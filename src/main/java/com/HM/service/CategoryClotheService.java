package com.HM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HM.model.CategoryClothe;
import com.HM.repository.CategoryClotheRepository;

@Service

public class CategoryClotheService {

	//Que voy a relacionar, como lo voy a relacionar, cuando lo voy a utilizar
	// Primero declaro una varible del tipo PlatilloRepository para usarla cuando la necesite

	private final CategoryClotheRepository categoryClotheRepository;

	// Creo un cable para conectar entidades (categoryClotheRepository - CategoryClotheService)
	@Autowired

	// Uso ese objeto como parametro de mi constructor
	public CategoryClotheService(CategoryClotheRepository categoryClotheRepository) {
		this.categoryClotheRepository = categoryClotheRepository;
	}

	// Logica de nuestro negocio

	// Operaciones del CRUD
	
	/****************************** CREATE ******************************/
	// Crear category clothe (Create)
	public void createCategoryClothe(CategoryClothe categoryClothe) {
		
		// Primero guardamos el dato en un optional
		// Si hay algo en ese Optional.isPresent nos regresa un true o un false
		
		// Necesitamos saber si el category clothe buscado existe
		Optional<CategoryClothe> findCategoryClothe = categoryClotheRepository.findByName(categoryClothe.getNameCategory()); // Buscamos por nombre
		
		if(findCategoryClothe.isPresent()) {
			throw new IllegalStateException("The admin names " + categoryClothe.getNameCategory() + " is already exists");
		}
		else {
			categoryClotheRepository.save(categoryClothe);
		}
		// Si no existe, entonces lo guardamos en la base de datos
	}

	/****************************** READ ******************************/
	
	// Leer category clothe (Read)
	public List<CategoryClothe> readCategoryClothes() {
		return categoryClotheRepository.findAll();
	}
	
	public CategoryClothe readCategoryClothe(Integer idCategoryClothe){
		 return categoryClotheRepository.findById(idCategoryClothe).orElseThrow(()-> new IllegalStateException("The category clothe " + "with id " + idCategoryClothe + " does not exist.") );
	}
	
	/****************************** UPDATE ******************************/
	
	// Actualizar category clothe (Update)
	
	//Necesitamos pasar todos los parametros, para contemplar todas las modificaciones posibles
	public void updateCategoryClothe(Integer idCategoryClothe, String nameCategory) {		
		//Si el category clothe existe, entonces se modifica
		if (categoryClotheRepository.existsById(idCategoryClothe)) {
			//entonces lo modifico
			
			//traigo el objeto, y lo pongo en la variable temporal
			CategoryClothe findCategoryClothe = categoryClotheRepository.getById(idCategoryClothe);
			if (nameCategory!=null) findCategoryClothe.setNameCategory(nameCategory);
			
			//cuando termino de editar el objeto...
			categoryClotheRepository.save(findCategoryClothe);
			//Si el category clothe NO existe, no puedo modificar nada y muestro un mensaje
		}else {
			System.out.println("The category clothe with id " + idCategoryClothe + " does not exist");
		}	
	}
	
	/****************************** DELETE ******************************/
	
	//Borrar category clothe (Delete)
		public void deleteCategoryClothe(Integer idCategoryClothe) {
			//Buscamos un category clothe por id, y si existe...
			if (categoryClotheRepository.existsById(idCategoryClothe)) {//true
				//Lo borramos
				categoryClotheRepository.deleteById(idCategoryClothe);
			}
		}
	
	// Actualizar category clothe (Update)
	// Borrar category clothe (Delete)
}
