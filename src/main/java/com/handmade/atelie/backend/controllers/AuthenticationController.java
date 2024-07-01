package com.handmade.atelie.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handmade.atelie.backend.exceptions.InvalidCredentialsException;
import com.handmade.atelie.backend.exceptions.UserNotFoundByEmailException;
import com.handmade.atelie.backend.infra.security.TokenService;
import com.handmade.atelie.backend.models.auth.AuthenticationDTO;
import com.handmade.atelie.backend.models.auth.LoginResponseDTO;
import com.handmade.atelie.backend.models.user.User;
import com.handmade.atelie.backend.models.user.UserLoginResponseDTO;
import com.handmade.atelie.backend.repositories.UserRepository;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Validated @RequestBody AuthenticationDTO data) {
        try {
            
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            UserLoginResponseDTO response = null;

            try {
                User user = this.userRepository.findUserByEmail(data.email());
                response = new UserLoginResponseDTO(user.getId(), user.getName(), user.getDateOfBirth(), user.getCpf() , user.getEmail());

            } catch (UserNotFoundByEmailException e) {
                throw new UserNotFoundByEmailException(data.email());
            }
            
            return ResponseEntity.ok(new LoginResponseDTO(token, response));

        } catch (Exception e) {
            throw new InvalidCredentialsException();
        }
    }

}
