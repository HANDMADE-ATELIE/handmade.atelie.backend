package com.handmade.atelie.backend.models.user;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public record UserDTOWithoutPassword(String id, String name, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dateOfBirth, String cpf, String email, UserRole role, List<PhoneNumberDTO> phoneNumbers) {

    public UserDTOWithoutPassword(String id, String name, Date dateOfBirth, String cpf, String email, UserRole role, List<PhoneNumberDTO> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cpf = cpf;
        this.email = email;
        this.role = role;
        this.phoneNumbers = phoneNumbers;
    }
           

}
