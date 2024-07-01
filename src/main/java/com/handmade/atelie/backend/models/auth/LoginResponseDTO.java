package com.handmade.atelie.backend.models.auth;

import com.handmade.atelie.backend.models.user.UserLoginResponseDTO;

public record LoginResponseDTO(String token, UserLoginResponseDTO user) {
}
