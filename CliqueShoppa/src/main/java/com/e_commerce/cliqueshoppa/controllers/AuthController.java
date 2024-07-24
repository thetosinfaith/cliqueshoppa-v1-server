package com.e_commerce.cliqueshoppa.controllers;

import com.e_commerce.cliqueshoppa.dtos.CreateUserDto;
import com.e_commerce.cliqueshoppa.service.interfaces.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class AuthController {
    private final AuthService authService;

    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdmin(@Valid @RequestBody CreateUserDto.Request request){
        CreateUserDto.Response response = authService.createAdmin(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/create-customer")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CreateUserDto.Request request){
        CreateUserDto.Response response = authService.createCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
