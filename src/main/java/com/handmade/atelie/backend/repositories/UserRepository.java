package com.handmade.atelie.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.handmade.atelie.backend.models.user.User;

public interface UserRepository extends JpaRepository<User, String>{
    UserDetails findByEmail(String email);
    UserDetails findByCpf(String cpf);
}
