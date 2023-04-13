package com.HM.controller;

import com.HM.model.Address;
import com.HM.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })

@RestController // Anotacion para indicar que esta clase es un controlador
@RequestMapping(path = "/wm/address/")
public class AddressController {

    // Inyeccion de dependencias
    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    // Solicitudes HTTP para traer todos los productos
    @GetMapping
    public List<Address> getAddress(){
        return addressService.readAddress();
    }

    // Traer un producto por ID
    @GetMapping(path = "{IDADDRESS}")

    // Con @PathVariable le digo a mi metodo que la ruta que va a variar es el id, con el tipo de dato Integer
    public Address getAddress(@PathVariable("IDADDRESS") String address) {
        return addressService.readAddress(address);
    }

    /****************************** POST address ******************************/

    // Solicitud HTTP POST para crear un producto
    @PostMapping
    public void postAddress(@RequestBody Address address) { // Los datos que pasemos como cuerpo de nuestra solicitud seran utilizados como campos de nuestro constructor
        addressService.createAddress(address); // aqui disparo la operacion del crud que modifica la base de datos.
    }

    /****************************** UPDATE ******************************/

    // Solicitud HTTP PUT para modificar un producto

    @PutMapping(path = "{IDADDRESS}")
    public void updateAddress(@PathVariable("IDADDRESS")Integer idAddress,
                              @RequestParam (required = false) String street,
                              @RequestParam (required = false) String number,
                              @RequestParam (required = false) String suburb,
                              @RequestParam (required = false) String cp,
                              @RequestParam (required = false) String state,
                              @RequestParam (required = false) String country)
    {
        addressService.updateAddress(idAddress, street, number, suburb, cp, state, country);
    }

    /****************************** DELETE ******************************/

    // Solicitud HTTP DELETE para eliminar un producto


    @DeleteMapping(path = "{IDADDRESS}")
    public void deleteAddress(@PathVariable("IDADDRESS")Integer idAddress) {
        addressService.deleteAddress(idAddress);
    }

    // GET Product (GET)

    // POST Product (POST)

    // PUT Product (PUT)

    // DELETE Product (DELETE)

}