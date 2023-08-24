package com.sss.testpet.api;

import com.sss.testpet.dto.RqCreatePet;
import com.sss.testpet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("create-pet")
    public ResponseEntity<?> createPet(@RequestBody RqCreatePet rq){
        return petService.createPet(rq);
    }

    @GetMapping("edit-petname")
    public ResponseEntity<?> editPetName(@RequestParam Long id, @RequestParam String name){
        return null;
    }

    @GetMapping("edit-pettype")
    public ResponseEntity<?> editPetType(@RequestParam Long id, @RequestParam String type){
        return ResponseEntity.status(HttpStatus.OK).body("Да ты что, волшебник?");
    }
}
