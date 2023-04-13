package com.HM.repository;

import com.HM.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("SELECT a FROM Address a WHERE street = ?1")
    Optional<Address> findByName(String street);

}
