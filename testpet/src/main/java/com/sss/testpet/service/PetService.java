package com.sss.testpet.service;

import com.sss.testpet.dto.RqCreatePet;
import com.sss.testpet.entity.PetEntity;
import com.sss.testpet.repository.PetRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PetService {
    private final PetRepository petRepository;

    public ResponseEntity<?> createPet(RqCreatePet rq){
        PetEntity newPet = new PetEntity()
                .setPetName(rq.getPetName())
                .setType(rq.getType())
                .setOwnerUserId(rq.getOwnerId());
        petRepository.save(newPet);
        return ResponseEntity.status(HttpStatus.CREATED).body("Питомец создан!");
    }

    public ResponseEntity<?> editPetName(Long id, String name){
        Optional<PetEntity> pet = petRepository.findById(id);

        if (!pet.isPresent())
            return ResponseEntity
                    .badRequest()
                    .body("Питомец не существует!");

        petRepository.updateById(name, pet.get().getType(), pet.get().getOwnerUserId(), id);

        return ResponseEntity.status(HttpStatus.OK).body("Питомец успешно переименован!");
    }
}
