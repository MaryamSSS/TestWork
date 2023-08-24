package com.sss.test.api;

import com.sss.test.dto.RqCreateUser;
import com.sss.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Создание пользователя
     * @param rq - поступивший запрос с данными создаваемого пользователя
     * @return - результат создания пользователя
     */
    @GetMapping("create-user")
    public ResponseEntity<?> createUser(@RequestBody RqCreateUser rq){
        return userService.createUser(rq);
    }

    /**
     * Поиск пользователя по id
     * @param id - id пользователя
     * @return - результат поиска пользователя по id
     */
    @GetMapping("search-user")
    public ResponseEntity<?> findUserById(@RequestParam Long id){
        return userService.findUserById(id);
    }

    /**
     * Удаление пользователя
     * @param id - id пользователя
     * @return - результат удаления пользователя
     */
    @GetMapping("delete-user")
    public ResponseEntity<?> deleteUser(@RequestParam Long id){
        return userService.deleteUser(id);
    }

    /**
     * Изменение имени пользователя
     * @param id - id пользователя
     * @param name - новое имя пользователя
     * @return - результат изменения имени пользователя
     */
    @GetMapping("edit-username")
    public ResponseEntity<?> editUsername(@RequestParam Long id, @RequestParam String name){
        return userService.editUsername(id, name);
    }

    /**
     * Изменение фамилии пользователя
     * @param id - id пользователя
     * @param surname - новая фамилия пользователя
     * @return - результат изменения фамилии пользователя
     */
    @GetMapping("edit-surname")
    public ResponseEntity<?> editSurname(@RequestParam Long id, @RequestParam String surname){
        return userService.editSurname(id, surname);
    }

    /**
     * Изменение отчества пользователя
     * @param id - id пользователя
     * @param patronymic - новое отчество пользователя
     * @return - результат изменения отчества пользователя
     */
    @GetMapping("edit-patronymic")
    public ResponseEntity<?> editPatronymic(@RequestParam Long id, @RequestParam String patronymic){
        return userService.editPatronymic(id, patronymic);
    }

    /**
     * Получение и вывод всех пользователей
     * @return - получение и вывод всех пользователей
     */
    @GetMapping("get-all-users")
    public ResponseEntity<?> getAllUsers(){
        return userService.getAllUsers();
    }
}
