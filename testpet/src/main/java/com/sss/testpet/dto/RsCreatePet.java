package com.sss.testpet.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RsCreatePet {
    private Long id;
    private String petName;
    private String type;
    private Long ownerId;
}
