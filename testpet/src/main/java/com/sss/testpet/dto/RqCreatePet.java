package com.sss.testpet.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RqCreatePet {
    private String petName;
    private String type;
    private Long ownerId;
}
