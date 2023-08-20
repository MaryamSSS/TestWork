package com.sss.test.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RsUserInfo {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String email;
}
