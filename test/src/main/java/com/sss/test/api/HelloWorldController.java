package com.sss.test.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    /**
     * Вывод "Hello, world!" в браузере
     * @return - строка "Hello, world!"
     */
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello, world!";
    }
}
