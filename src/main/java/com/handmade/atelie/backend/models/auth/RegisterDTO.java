package com.handmade.atelie.backend.models.auth;

import com.handmade.atelie.backend.models.user.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
}
