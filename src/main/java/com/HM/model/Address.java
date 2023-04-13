package com.HM.model;

import lombok.*;

import javax.persistence.*;

@Entity
// Esta clase product se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una DB)
@Table(name = "ADDRESS") // Especificamos el nombre de la tabla de mysql a donde llega esta informacion
@Getter// Libreria de lombok sirve para omitir hacer los getter, setter constructor y metodo toString
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Address {

    @Id //especificamos que nuestra llave primaria es el campo id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estrategia de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)

    @Column(name = "IDADDRESS", unique = true, nullable = false)
    private Integer idAddress;

    @Column(name = "STREET", unique = true, nullable = false)
    private String street;

    @Column(name = "NUMBER", unique = true, nullable = false)
    private String number;

    @Column(name = "SUBURB", unique = true, nullable = false)
    private String suburb;



    @Column(name = "CP", unique = true, nullable = false)
    private String cp;

    @Column(name = "STATE", unique = true, nullable = false)
    private String state;

    @Column(name = "COUNTRY", unique = true, nullable = false)
    private String country;

    @Column(name = "FK_IDCUSTOMER", unique = true, nullable = false)
    private Integer fk_idCustomer;


    public Address() {
    }

    public Address(Integer idAddress, String street, String number, String suburb, String cp, String state, String country, Integer fk_idCustomer) {
        this.idAddress = idAddress;
        this.street = street;
        this.number = number;
        this.suburb = suburb;
        this.cp = cp;
        this.state = state;
        this.country = country;
        this.fk_idCustomer = fk_idCustomer;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getFk_idCustomer() {
        return fk_idCustomer;
    }

    public void setFk_idCustomer(Integer fk_idCustomer) {
        this.fk_idCustomer = fk_idCustomer;
    }
}
