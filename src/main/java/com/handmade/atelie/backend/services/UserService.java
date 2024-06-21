package com.handmade.atelie.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.handmade.atelie.backend.helpers.CustomException;
import com.handmade.atelie.backend.models.user.Address;
import com.handmade.atelie.backend.models.user.PhoneNumber;
import com.handmade.atelie.backend.models.user.User;
import com.handmade.atelie.backend.models.user.UserDTO;
import com.handmade.atelie.backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void registerUser(UserDTO data) {

        if(this.userRepository.findByEmail(data.email()) != null)
            throw new CustomException("Email already exists");
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(data.name(), data.dateOfBirth(), data.cpf(), data.email(), encryptedPassword, data.role(), data.gender());

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

        this.userRepository.save(newUser);

         // todo - validade cpf, validate numberPhone, cep, email, role, state
        // criar service e tbm separar o register em um controller próprio para o crud de usuários
        
    }

}
