package com.javanauta.usuario.controller;


import com.javanauta.usuario.infrastructure.exceptions.ConflitException;
import com.javanauta.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.usuario.infrastructure.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.module.ResolutionException;

@ControllerAdvice
public class GlobalExcaptionHandler {

    @ExceptionHandler(ResolutionException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflitException.class)
    public ResponseEntity<String> handleConflictException(ConflitException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(com.javanauta.usuario.infrastructure.exceptions.IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
