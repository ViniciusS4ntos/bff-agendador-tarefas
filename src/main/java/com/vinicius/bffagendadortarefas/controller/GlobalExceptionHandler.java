package com.vinicius.bffagendadortarefas.controller;

import com.vinicius.bffagendadortarefas.infrastructure.exception.ConflictException;
import com.vinicius.bffagendadortarefas.infrastructure.exception.InvalidCepException;
import com.vinicius.bffagendadortarefas.infrastructure.exception.ResourceNotFoundException;
import com.vinicius.bffagendadortarefas.infrastructure.exception.UnauthorizedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Excecao global
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflictException(ConflictException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCepException.class)
    public ResponseEntity<String> handleInvalidCepException(InvalidCepException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
