package com.HM.service;

import com.HM.model.Address;
import com.HM.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    /****************************** CREATE ******************************/
    public void createAddress(Address address){

        Optional<Address> findAddress = addressRepository.findByName(address.getStreet());

        if(findAddress.isPresent()){
            throw new IllegalStateException(("The street names " + address.getStreet() + " is already exists"));
        }
        else{
            addressRepository.save(address);
        }
    }

    /****************************** READ ******************************/
    public List<Address> readAddress(){
        return addressRepository.findAll();
    }

    public Address readAddress(String street){
        return addressRepository.findByName(street).orElseThrow(() -> new IllegalStateException(("The street " + "with name " + street + " doesn't exist.")));
    }

    /****************************** UPDATE ******************************/


    public void updateAddress(Integer idAddress, String street, String number, String suburb, String cp, String state, String country) {
        //Si el direccion existe, entonces se modifica
        if (addressRepository.existsById(idAddress)) {
            //entonces lo modifico

            //traigo el objeto, y lo pongo en la variable temporal
            Address findAddress = addressRepository.getById(idAddress);
            if (street!=null) findAddress.setStreet(street);
            if (number!=null) findAddress.setNumber(number);
            if (suburb!=null) findAddress.setSuburb(suburb);
            if (cp!=null) findAddress.setCp(cp);
            if (state!=null) findAddress.setState(state);
            if (country!=null) findAddress.setCountry(country);

            //cuando termino de editar el objeto...
            addressRepository.save(findAddress);
            //Si el direccion NO existe, no puedo modificar nada y muestro un mensaje
        }else {
            System.out.println("The address with id " + idAddress + " does not exist");
        }
    }

    /****************************** DELETE ******************************/

    //Borrar direccion (Delete)
    public void deleteAddress(Integer idAddress) {
        //Buscamos un direccion por id, y si existe...
        if (addressRepository.existsById(idAddress)) {//true
            //Lo borramos
            addressRepository.deleteById(idAddress);
        }
    }

    // Actualizar direccion (Update)
    // Borrar direccion (Delete)

}