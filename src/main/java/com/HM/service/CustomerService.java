package com.HM.service;

import com.HM.model.Customer;
import com.HM.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    //Que voy a relacionar, como lo voy a relacionar, cuando lo voy a utilizar
    // Primero declaro una varible del tipo PlatilloRepository para usarla cuando la necesite

    private final CustomerRepository customerRepository;

    // Creo un cable para conectar entidades (CustomerRepository - CustomerService)
    @Autowired

    // Uso ese objeto como parametro de mi constructor
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    // Logica de nuestro negocio

    // Operaciones del CRUD

    /****************************** CREATE ******************************/
    // Crear customer (Create)
    public void createCustomer(Customer customer) {

        // Primero guardamos el dato en un optional
        // Si hay algo en ese Optional.isPresent nos regresa un true o un false

        // Necesitamos saber si el customer buscado existe
        Optional<Customer> findCustomer = customerRepository.findByName(customer.getFirstName()); // Buscamos por nombre

        if(findCustomer.isPresent()) {
            throw new IllegalStateException("The customer names " + customer.getFirstName() + " is already exists");
        }
        else {
            customerRepository.save(customer);
        }
        // Si no existe, entonces lo guardamos en la base de datos
    }

    /****************************** READ ******************************/

    // Leer customer (Read)
    public List<Customer> readCustomer() {

        return customerRepository.findAll();
    }

    public Customer readCustomer(Integer idCustomer){
        return customerRepository.findById(idCustomer).orElseThrow(()-> new IllegalStateException("The customer " + "with id " + idCustomer + " does not exist.") );
    }

    /****************************** UPDATE ******************************/

    // Actualizar customer (Update)

    //Necesitamos pasar todos los parametros, para contemplar todas las modificaciones posibles
    public void updateCustomer(Integer idCustomer, String firstName, String lastName, String email, String password) {
        //Si el customer existe, entonces se modifica
        if (customerRepository.existsById(idCustomer)) {
            //entonces lo modifico

            //traigo el objeto, y lo pongo en la variable temporal
            Customer findCustomer = customerRepository.getById(idCustomer);
            if (firstName!=null) findCustomer.setFirstName(firstName);
            if (lastName!=null) findCustomer.setLastName(lastName);
            if (email!=null) findCustomer.setEmail(email);
            if (password!=null) findCustomer.setPassword(password);

            //cuando termino de editar el objeto...
            customerRepository.save(findCustomer);
            //Si el customer NO existe, no puedo modificar nada y muestro un mensaje
        }else {
            System.out.println("The customer with id " + idCustomer + " doesn't exist");
        }
    }

    /****************************** DELETE ******************************/

    //Borrar customer (Delete)
    public void deleteCustomer(Integer idCustomer) {
        //Buscamos un customer por id, y si existe...
        if (customerRepository.existsById(idCustomer)) {//true
            //Lo borramos
            customerRepository.deleteById(idCustomer);
        }
    }

    // Actualizar customer (Update)
    // Borrar customer (Delete)

}
