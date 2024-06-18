package com.handmade.atelie.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handmade.atelie.backend.models.user.Address;

public interface AddressRepository extends JpaRepository<Address, String> {
    
}
