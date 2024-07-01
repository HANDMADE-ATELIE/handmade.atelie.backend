package com.handmade.atelie.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handmade.atelie.backend.models.user.UserDTO;
import com.handmade.atelie.backend.models.user.UserDTOWithoutPassword;
import com.handmade.atelie.backend.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registerCustomerUser")
    public ResponseEntity<UserDTOWithoutPassword> registerCustomerUser(@Validated @RequestBody UserDTO data) {
        UserDTOWithoutPassword result = this.userService.registerCustomerUser(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @PostMapping("/registerAdminUser")
    public ResponseEntity<UserDTOWithoutPassword> registerAdminUser(@Validated @RequestBody UserDTO data) {
        UserDTOWithoutPassword result = this.userService.registerAdminUser(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTOWithoutPassword> putMethodName(@PathVariable String id, @RequestBody UserDTO data) {
        UserDTOWithoutPassword result = this.userService.updateUserById(id, data);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        this.userService.deleteUserById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTOWithoutPassword> getUserById(@PathVariable String id) {
        UserDTOWithoutPassword result = this.userService.getUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    

}
