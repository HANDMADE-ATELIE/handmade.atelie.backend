package com.handmade.atelie.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.handmade.atelie.backend.exceptions.CPFAlreadyExistsException;
import com.handmade.atelie.backend.exceptions.EmailAlreadyExistsException;
import com.handmade.atelie.backend.exceptions.InvalidAgeException;
import com.handmade.atelie.backend.exceptions.InvalidCpfCharException;
import com.handmade.atelie.backend.exceptions.InvalidCpfException;
import com.handmade.atelie.backend.exceptions.InvalidEmailFormatException;
import com.handmade.atelie.backend.exceptions.InvalidPhoneNumberException;
import com.handmade.atelie.backend.helpers.HelperMethods;
import com.handmade.atelie.backend.models.user.PhoneNumber;
import com.handmade.atelie.backend.models.user.PhoneNumberDTO;
import com.handmade.atelie.backend.models.user.User;
import com.handmade.atelie.backend.models.user.UserDTO;
import com.handmade.atelie.backend.models.user.UserDTOWithoutPassword;
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

        if(HelperMethods.isValidEmail(data.email())) {
            if(this.userRepository.findByEmail(data.email()) != null)
                throw new EmailAlreadyExistsException();

        } else {
            throw new InvalidEmailFormatException();

        }


        if(HelperMethods.isNotHaveNumbersChars(data.cpf())) {
            throw new InvalidCpfCharException();

        } else {

            if(HelperMethods.isValidCPF(data.cpf())) {
                if(this.userRepository.findByCpf(data.cpf()) != null)
                    throw new CPFAlreadyExistsException();

            } else {
                throw new InvalidCpfException();

            }

        }
        
        data.phoneNumbers().forEach(phone -> {
            if(!HelperMethods.isValidPhoneNumber(phone.phoneNumber()))
                throw new InvalidPhoneNumberException();

        });

        if(!HelperMethods.isAgeOverEighteen(data.dateOfBirth()))
            throw new InvalidAgeException();
        
    }

    public UserDTOWithoutPassword registerCustomerUser(UserDTO data) {

        this.validateUserData(data);
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.dateOfBirth(), data.cpf(), data.email(), encryptedPassword, data.role());

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        data.phoneNumbers().forEach(phone -> {

            PhoneNumber newPhone = new PhoneNumber(phone.phoneNumber(), newUser);
            phoneNumbers.add(newPhone);

        });
        newUser.setPhoneNumbers(phoneNumbers);
        newUser.setRole(UserRole.CUSTOMER);

        this.userRepository.save(newUser);

        List<PhoneNumberDTO> phoneNumbersDTO = new ArrayList<>();
        newUser.getPhoneNumbers().forEach(phone -> {
            phoneNumbersDTO.add(new PhoneNumberDTO(phone.getId(), phone.getPhoneNumber()));
        });

        return new UserDTOWithoutPassword(newUser.getId() ,newUser.getName(), newUser.getDateOfBirth(), newUser.getCpf(), newUser.getEmail(), newUser.getRole(), phoneNumbersDTO);    
    }

}
