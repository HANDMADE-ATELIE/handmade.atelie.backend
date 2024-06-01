package com.handmade.atelie.backend.models.user;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;
    
    UserRole(String role){
        this.role = role;
    }
    
    public String getRole() {
        return role;
    }
}
