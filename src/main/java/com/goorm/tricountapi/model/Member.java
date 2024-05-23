package com.goorm.tricountapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;
    private String loginId;
    private String name;
    private String password;
}
