package com.handmade.atelie.backend.models.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record UserLoginResponseDTO(String id, String name, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dateOfBirth, String cpf, String email) {

    public UserLoginResponseDTO(String id, String name, Date dateOfBirth, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cpf = cpf;
        this.email = email;
    }
    
}
