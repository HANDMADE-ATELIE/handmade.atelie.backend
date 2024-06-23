package com.handmade.atelie.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.handmade.atelie.backend.exceptions.CPFAlreadyExistsException;
import com.handmade.atelie.backend.exceptions.EmailAlreadyExistsException;
import com.handmade.atelie.backend.exceptions.InvalidCpfCharException;
import com.handmade.atelie.backend.exceptions.InvalidCpfException;
import com.handmade.atelie.backend.exceptions.InvalidRoleException;
import com.handmade.atelie.backend.exceptions.InvalidStateException;
import com.handmade.atelie.backend.helpers.HelperMethods;
import com.handmade.atelie.backend.models.user.Address;
import com.handmade.atelie.backend.models.user.PhoneNumber;
import com.handmade.atelie.backend.models.user.State;
import com.handmade.atelie.backend.models.user.User;
import com.handmade.atelie.backend.models.user.UserDTO;
import com.handmade.atelie.backend.models.user.UserRole;
import com.handmade.atelie.backend.repositories.StateRepository;
import com.handmade.atelie.backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StateRepository stateRepository;

    private void validateUserData(UserDTO data) {

        if(this.userRepository.findByEmail(data.email()) != null)
            throw new EmailAlreadyExistsException();

        if(HelperMethods.isNotNumbersChars(data.cpf())) {
            throw new InvalidCpfCharException();

        } else {
            if(HelperMethods.isValidCPF(data.cpf())) {
                if(this.userRepository.findByCpf(data.cpf()) != null)
                    throw new CPFAlreadyExistsException();
                    
            } else {
                throw new InvalidCpfException();
            }
        }

        if(data.role() != UserRole.ADMIN && data.role() != UserRole.USER)
            throw new InvalidRoleException();

        data.addresses().forEach(address -> {
            if(this.stateRepository.findByAcronym(address.stateAcronym()) == null)
                throw new InvalidStateException();
        });
        
            // todo - validate numberPhone, cep, email, role, state
        // verificar poque a data está sendo salva 1 dia antes
    }

    public void registerUser(UserDTO data) {

        this.validateUserData(data);
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.dateOfBirth(), data.cpf(), data.email(), encryptedPassword, data.role(), data.gender());

        List<Address> addresses = new ArrayList<>();
        data.addresses().forEach(address -> {

            State state = this.stateRepository.findByAcronym(address.stateAcronym());
            Address newAddress = new Address(address.zipCode(), state, address.street(), address.number(), address.neighborhood(), address.city(), address.complement(), newUser);
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
        
    }

}
