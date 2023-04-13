package com.HM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HM.model.Admin;
import com.HM.repository.AdminRepository;

@Service

public class AdminService {

	//Que voy a relacionar, como lo voy a relacionar, cuando lo voy a utilizar
	// Primero declaro una varible del tipo PlatilloRepository para usarla cuando la necesite

	private final AdminRepository adminRepository;

	// Creo un cable para conectar entidades (AdminRepository - AdminService)
	@Autowired

	// Uso ese objeto como parametro de mi constructor
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	// Logica de nuestro negocio

	// Operaciones del CRUD
	
	/****************************** CREATE ******************************/
	// Crear producto (Create)
	public void createAdmin(Admin admin) {
		
		// Primero guardamos el dato en un optional
		// Si hay algo en ese Optional.isPresent nos regresa un true o un false
		
		// Necesitamos saber si el producto buscado existe
		Optional<Admin> findAdmin = adminRepository.findByEmail(admin.getEmail()); // Buscamos por nombre
		
		if(findAdmin.isPresent()) {
			throw new IllegalStateException("The admin names " + admin.getEmail() + " is already exists");
		}
		else {
			adminRepository.save(admin);
		}
		// Si no existe, entonces lo guardamos en la base de datos
	}

	/****************************** READ ******************************/
	
	// Leer producto (Read)
	public List<Admin> readAdmins() {
		return adminRepository.findAll();
	}
	
	public Admin readAdmin(Integer idAdmin){
		 return adminRepository.findById(idAdmin).orElseThrow(()-> new IllegalStateException("The admin " + "with id " + idAdmin + " does not exist.") );
	}
	
	/****************************** UPDATE ******************************/
	
	// Actualizar admin (Update)
	
	//Necesitamos pasar todos los parametros, para contemplar todas las modificaciones posibles
	public void updateAdmin(Integer idAdmin, String email, String password) {		
		//Si el admin existe, entonces se modifica
		if (adminRepository.existsById(idAdmin)) {
			//entonces lo modifico
			
			//traigo el objeto, y lo pongo en la variable temporal
			Admin findAdmin = adminRepository.getById(idAdmin);
			if (email!=null) findAdmin.setEmail(email);
			if (password!=null) findAdmin.setPassword(password);
			
			//cuando termino de editar el objeto...
			adminRepository.save(findAdmin);
			//Si el admin NO existe, no puedo modificar nada y muestro un mensaje
		}else {
			System.out.println("The admin with id " + idAdmin + " does not exist");
		}	
	}
	
	/****************************** DELETE ******************************/
	
	//Borrar admin (Delete)
		public void deleteAdmin(Integer idAdmin) {
			//Buscamos un admin por id, y si existe...
			if (adminRepository.existsById(idAdmin)) {//true
				//Lo borramos
				adminRepository.deleteById(idAdmin);
			}
		}
	
	// Actualizar admin (Update)
	// Borrar admin (Delete)
}
