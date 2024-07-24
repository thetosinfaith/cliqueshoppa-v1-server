package com.e_commerce.cliqueshoppa.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class LoginDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request{
        @Email(message = "valid email required")
        @NotBlank(message = "email is required")
        private String email;

        @NotBlank(message = "password is required")
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response{
        private String message;
    }
}
