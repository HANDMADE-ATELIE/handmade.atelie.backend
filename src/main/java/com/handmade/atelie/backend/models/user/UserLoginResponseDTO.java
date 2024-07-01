package com.handmade.atelie.backend.models.user;

public record UserLoginResponseDTO(String id) {

    public UserLoginResponseDTO(String id) {
        this.id = id;
    }
    
}
