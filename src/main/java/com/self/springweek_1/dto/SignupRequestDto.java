package com.self.springweek_1.dto;


import lombok.*;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String password_check;
    private String email;

}