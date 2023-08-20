package com.sss.test.service;

import com.sss.test.dto.RqCreateUser;
import com.sss.test.dto.RsUserInfo;
import com.sss.test.entity.UserEntity;
import com.sss.test.repository.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<?> createUser(RqCreateUser rq){
        UserEntity newUser = new UserEntity()
                .setName(rq.getName())
                .setSurname(rq.getSurname())
                .setPatronymic(rq.getPatronymic())
                .setEmail(rq.getEmail())
                .setPhone(rq.getPhone())
                .setPassword(rq.getPassword()
                );
        userRepository.save(newUser);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Пользователь создан!");
    }

    public ResponseEntity<?> findUserById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);

        if (!user.isPresent())
            return ResponseEntity
                    .badRequest()
                    .body("Пользователь не существует!");

        RsUserInfo userInfo = new RsUserInfo()
                .setId(user.get().getId())
                .setName(user.get().getName())
                .setSurname(user.get().getSurname())
                .setPatronymic(user.get().getPatronymic())
                .setEmail(user.get().getEmail())
                .setPhone(user.get().getPhone());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userInfo);
    }

    public ResponseEntity<?> deleteUser(Long id){
        Optional<UserEntity> user = userRepository.findById(id);

        if (!user.isPresent())
            return ResponseEntity
                    .badRequest()
                    .body("Пользователь не существует!");

        userRepository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Удаление прошло успешно!");
    }

    @Transactional
    public ResponseEntity<?> editUsername(Long id, String name){
        Optional<UserEntity> user = userRepository.findById(id);

        if (!user.isPresent())
            return ResponseEntity
                    .badRequest()
                    .body("Пользователь не существует!");

        userRepository.updateById(name, user.get().getSurname(), user.get().getPatronymic(), user.get().getEmail(), user.get().getPassword(), user.get().getPhone(), id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Имя пользователя успешно обновлено! Новое имя: " + name);
    }

    @Transactional
    public ResponseEntity<?> editSurname(Long id, String surname){
        Optional<UserEntity> user = userRepository.findById(id);

        if (!user.isPresent())
            return ResponseEntity
                    .badRequest()
                    .body("Пользователь не существует!");

        userRepository.updateById(user.get().getName(), surname, user.get().getPatronymic(), user.get().getEmail(), user.get().getPassword(), user.get().getPhone(), id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Фамилия пользователя успешно обновлена! Новая фамилия: " + surname);
    }

    @Transactional
    public ResponseEntity<?> editPatronymic(Long id, String patronymic){
        Optional<UserEntity> user = userRepository.findById(id);

        if (!user.isPresent())
            return ResponseEntity
                    .badRequest()
                    .body("Пользователь не существует!");

        userRepository.updateById(user.get().getName(), user.get().getSurname(), patronymic, user.get().getEmail(), user.get().getPassword(), user.get().getPhone(), id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Отчество пользователя успешно обновлено! Новое отчество: " + patronymic);
    }

    public ResponseEntity<?> getAllUsers(){
        List<UserEntity> userList = userRepository.findAll();
        if (userList.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Пользователи не найдены!");
        }

        List<RsUserInfo> userInfoList = new ArrayList<>();

        for (UserEntity user : userList){
            RsUserInfo userInfo = new RsUserInfo()
                    .setId(user.getId())
                    .setName(user.getName())
                    .setSurname(user.getSurname())
                    .setPatronymic(user.getPatronymic())
                    .setPhone(user.getPhone())
                    .setEmail(user.getEmail());
            userInfoList.add(userInfo);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userInfoList);
    }
}
