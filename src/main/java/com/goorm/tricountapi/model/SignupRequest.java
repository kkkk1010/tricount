package com.goorm.tricountapi.model;


import lombok.Data;

@Data
public class SignupRequest {
    private String loginId;
    private String password;
    private String name;
}
