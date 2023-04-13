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

import com.HM.model.Admin;
import com.HM.service.AdminService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping (path = "/wm/admin/")

public class AdminController {
	// Inyeccion de dependencias
	private final AdminService adminService;
	
	@Autowired // Anotacion para relacionar e inyectar dependencia
	// Constructor que usa el objeto AdminService como parametro
	public AdminController (AdminService adminService) {
		this.adminService = adminService;
	}
	
	// Solicitudes HTTP para traer todos los Adminos
	@GetMapping
	public List<Admin> getAdmins(){
		return adminService.readAdmins();
	}
	
	// Traer un Admino por ID
	@GetMapping(path = "{idAdmin}")
	
	// Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
	public Admin getAdmin(@PathVariable("idAdmin") Integer idAdmin) {
		return adminService.readAdmin(idAdmin);
	}
	
/****************************** POST ******************************/
	
	// Solicitud HTTP POST para crear un Admino
	@PostMapping
	public void postAdmin(@RequestBody Admin admin) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
		adminService.createAdmin(admin); // aqui disparo la operacion del crud que modifica la base de datos.
	}
	
	/****************************** UPDATE ******************************/
	
	// Solicitud HTTP PUT para modificar un Admino
	
	@PutMapping(path = "{idAdmin}")
	public void updateAdmin(@PathVariable ("idAdmin") Integer idAdmin, 
			@RequestParam (required = false) String email,
			@RequestParam (required = false) String password)
	{
		adminService.updateAdmin(idAdmin, email, password);
	}
	
	/****************************** DELETE ******************************/
	
	// Solicitud HTTP DELETE para eliminar un Admino
	
	
	@DeleteMapping(path = "{idAdmin}")
	public void deleteAdmin(@PathVariable("idAdmin")Integer idAdmin) {
		adminService.deleteAdmin(idAdmin);
	}
	
	// GET Admin (GET)
	
	// POST Admin (POST)
	
	// PUT Admin (PUT)
	
	// DELETE Admin (DELETE)
}
