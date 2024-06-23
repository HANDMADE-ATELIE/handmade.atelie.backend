package com.handmade.atelie.backend.infra.restExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.handmade.atelie.backend.exceptions.CPFAlreadyExistsException;
import com.handmade.atelie.backend.exceptions.EmailAlreadyExistsException;
import com.handmade.atelie.backend.exceptions.InvalidCpfCharException;
import com.handmade.atelie.backend.exceptions.InvalidCpfException;
import com.handmade.atelie.backend.exceptions.InvalidCredentialsException;
import com.handmade.atelie.backend.exceptions.InvalidRoleException;
import com.handmade.atelie.backend.exceptions.InvalidStateException;
import com.handmade.atelie.backend.exceptions.JWTCreationErrorException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(InvalidCredentialsException.class)
    private ResponseEntity<RestErrorMessage> invalidCredentialsHandler(InvalidCredentialsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage> emailAlreadyExistsHandler(EmailAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(CPFAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage> cpfAlreadyExistsHandler(CPFAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(InvalidRoleException.class)
    private ResponseEntity<RestErrorMessage> invalidRoleHandler(InvalidRoleException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(InvalidStateException.class)
    private ResponseEntity<RestErrorMessage> invalidStateHandler(InvalidStateException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(JWTCreationErrorException.class)
    private ResponseEntity<RestErrorMessage> JWTCreationErrorHandler(JWTCreationErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(InvalidCpfException.class)
    private ResponseEntity<RestErrorMessage> invalidCpfHandler(InvalidCpfException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(InvalidCpfCharException.class)
    private ResponseEntity<RestErrorMessage> invalidCpfCharHandler(InvalidCpfCharException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErrorMessage> defaultHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }
    
}
