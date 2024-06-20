package com.handmade.atelie.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handmade.atelie.backend.infra.security.TokenService;
import com.handmade.atelie.backend.models.auth.AuthenticationDTO;
import com.handmade.atelie.backend.models.auth.LoginResponseDTO;
import com.handmade.atelie.backend.models.user.Address;
import com.handmade.atelie.backend.models.user.PhoneNumber;
import com.handmade.atelie.backend.models.user.User;
import com.handmade.atelie.backend.models.user.UserDTO;
import com.handmade.atelie.backend.repositories.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Validated @RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    // todo - validade cpf, validate numberPhone, cep, email, role, state
    // criar service e tbm separar o register em um controller próprio para o crud de usuários

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Validated @RequestBody UserDTO data) {
        if(this.repository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.dateOfBirth(), data.cpf(), data.email(), encryptedPassword, data.role());

        List<Address> addresses = new ArrayList<>();
        data.addresses().forEach(address -> {
            Address newAddress = new Address(address.zipCode(), address.state(), address.street(), address.number(), address.neighborhood(), address.city(), address.complement(), newUser);
            addresses.add(newAddress);
        });

        newUser.setAddresses(addresses);

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        data.phoneNumbers().forEach(phone -> {
            PhoneNumber newPhone = new PhoneNumber(phone.phoneNumber(), newUser);
            phoneNumbers.add(newPhone);
        });

        newUser.setPhoneNumbers(phoneNumbers);
        

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
