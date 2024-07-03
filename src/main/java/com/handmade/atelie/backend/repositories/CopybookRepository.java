package com.handmade.atelie.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handmade.atelie.backend.models.product.Copybook;


public interface CopybookRepository extends JpaRepository<Copybook, String>{
}
