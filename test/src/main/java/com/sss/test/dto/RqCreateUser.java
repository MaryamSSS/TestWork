package com.sss.test.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RqCreateUser {
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String password;
    private String phone;
}