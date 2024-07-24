package com.e_commerce.cliqueshoppa.service.interfaces;

import com.e_commerce.cliqueshoppa.dtos.CreateUserDto;
import com.e_commerce.cliqueshoppa.dtos.LoginDto;

public interface AuthService {
    CreateUserDto.Response createCustomer(CreateUserDto.Request request);
    CreateUserDto.Response createAdmin(CreateUserDto.Request request);
    LoginDto.Response login(LoginDto.Request request);
}
