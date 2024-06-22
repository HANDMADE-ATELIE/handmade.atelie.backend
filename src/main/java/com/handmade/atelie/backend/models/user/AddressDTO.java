package com.handmade.atelie.backend.models.user;

public record AddressDTO (String zipCode, String stateAcronym, String street, String number, String neighborhood, String city, String complement) {
}

