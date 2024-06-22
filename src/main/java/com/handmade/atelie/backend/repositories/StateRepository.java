package com.handmade.atelie.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handmade.atelie.backend.models.user.State;

public interface StateRepository extends JpaRepository<State, String>{
    State findByAcronym(String acronym);
}
