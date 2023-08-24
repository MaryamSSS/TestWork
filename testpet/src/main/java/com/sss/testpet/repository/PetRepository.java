package com.sss.testpet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository {
    @Modifying
    @Query("UPDATE PetEntity pet SET pet.name = ?1, pet.type = ?2, pet.owner_id " + "WHERE user.id = ?7")
    void updateById(String name, String type, Long ownerId, Long id);
}