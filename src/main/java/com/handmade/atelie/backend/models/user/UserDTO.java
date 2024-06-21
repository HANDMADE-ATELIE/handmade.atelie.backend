package com.handmade.atelie.backend.models.user;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public record UserDTO(String name, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dateOfBirth, String cpf, String email, String password, UserRole role, String gender, List<PhoneNumberDTO> phoneNumbers, List<AddressDTO> addresses) {
}
