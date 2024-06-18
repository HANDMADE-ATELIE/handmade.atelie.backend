package com.handmade.atelie.backend.models.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record UserDTO(String name, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dateOfBirth, String cpf, String email, String password, UserRole role, String phone, AddressDTO address) {
}
