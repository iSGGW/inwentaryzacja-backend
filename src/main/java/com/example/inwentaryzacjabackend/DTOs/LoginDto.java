package com.example.inwentaryzacjabackend.DTOs;

import lombok.Data;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}