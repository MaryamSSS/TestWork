package com.sss.test.repository;

import com.sss.test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Modifying
    @Query("UPDATE UserEntity user SET user.name = ?1, user.surname = ?2, user.patronymic = ?3, user.email = ?4, user.password = ?5, user.phone = ?6, " + "WHERE user.id = ?7")
    void updateById(String name, String surname, String patronymic, String email, String password, String phone, Long id);
}
