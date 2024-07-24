package com.e_commerce.cliqueshoppa.dtos;

import com.e_commerce.cliqueshoppa.data.models.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class CreateUserDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request{
        @NotBlank(message = "name is required")
        private String name;

        @Email(message = "valid email required")
        @NotBlank(message = "email is required")
        private String email;

        @NotBlank(message = "password is required")
        private String password;

        @NotBlank(message = "phone number is required")
        private String phoneNumber;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response{
        private Long id;
        private String name;
        private String email;
        private String message;
        private UserRole role;
    }
}
