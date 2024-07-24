package com.e_commerce.cliqueshoppa.service.implementation;

import com.e_commerce.cliqueshoppa.data.models.User;
import com.e_commerce.cliqueshoppa.data.models.UserRole;
import com.e_commerce.cliqueshoppa.data.repositories.UserRepository;
import com.e_commerce.cliqueshoppa.dtos.CreateUserDto;
import com.e_commerce.cliqueshoppa.dtos.LoginDto;
import com.e_commerce.cliqueshoppa.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Override
    public CreateUserDto.Response createCustomer(CreateUserDto.Request request){
        User newCustomer = buildUser(request);
        newCustomer.setRole(UserRole.CUSTOMER);
        User savedCustomer = userRepository.save(newCustomer);
        CreateUserDto.Response response = new CreateUserDto.Response();
        BeanUtils.copyProperties(savedCustomer,response);
        return response;
    }

    @Override
    public CreateUserDto.Response createAdmin(CreateUserDto.Request request){
        User newAdmin = buildUser(request);
        newAdmin.setRole(UserRole.ADMIN);
        User savedCustomer = userRepository.save(newAdmin);
        CreateUserDto.Response response = new CreateUserDto.Response();
        BeanUtils.copyProperties(savedCustomer,response);
        return response;
    }

    @Override
    public LoginDto.Response login(LoginDto.Request request) {
        Optional<User> foundUser = findByEmail(request.getEmail());

        if(foundUser.isEmpty()){
            throw new RuntimeException("Bad Credentials");
        }

        if(!foundUser.get().getPassword().equals(request.getPassword())){
            throw new RuntimeException("Bad Credentials");
        }

        return LoginDto.Response.builder().message("Login Successful").build();
    }

    private User buildUser(CreateUserDto.Request request){
        Optional<User> foundUser = findByEmail(request.getEmail());
        if(foundUser.isPresent()){
            throw new RuntimeException(String.format("User with email '%s' already exists",request.getEmail()));
        }

        User newUser = new User();
        BeanUtils.copyProperties(request,newUser);
        return newUser;
    }

    private Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
