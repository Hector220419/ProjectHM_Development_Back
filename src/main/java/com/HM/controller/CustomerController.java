package com.HM.controller;

import com.HM.model.Customer;
import com.HM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping(path = "/wm/customer/")

public class CustomerController {

    // Inyeccion de dependencias
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    // Solicitudes HTTP para traer todos los productos
    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.readCustomer();
    }

    // Traer un producto por ID
    @GetMapping(path = "{idCustomer}")

    // Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
    public Customer getCustomer(@PathVariable("idCustomer") Integer idCustomer) {
        return customerService.readCustomer(idCustomer);
    }

    /****************************** POST ******************************/

    // Solicitud HTTP POST para crear un producto
    @PostMapping
    public void postCustomer(@RequestBody Customer customer) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
        customerService.createCustomer(customer); // aqui disparo la operacion del crud que modifica la base de datos.
    }

    /****************************** UPDATE ******************************/

    // Solicitud HTTP PUT para modificar un producto

    @PutMapping(path = "{idCustomer}")
    public void updateProduct(@PathVariable("idCustomer")Integer idCustomer,
                              @RequestParam (required = false) String firstName,
                              @RequestParam (required = false) String lastName,
                              @RequestParam (required = false) String email,
                              @RequestParam (required = false) String password)
    {
        customerService.updateCustomer(idCustomer,firstName, lastName, email, password);
    }

    /****************************** DELETE ******************************/

    // Solicitud HTTP DELETE para eliminar un producto


    @DeleteMapping(path = "{idCustomer}")
    public void deleteCustomer(@PathVariable("idCustomer")Integer idCustomer) {
        customerService.deleteCustomer(idCustomer);
    }

    // GET Product (GET)

    // POST Product (POST)

    // PUT Product (PUT)

    // DELETE Product (DELETE)

}