package com.sss.testpet.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "test_pet_schema", name = "pet")
@Accessors(chain = true)
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "type")
    private String type;

    @Column(name = "owner_user_id")
    private Long ownerUserId;
}
