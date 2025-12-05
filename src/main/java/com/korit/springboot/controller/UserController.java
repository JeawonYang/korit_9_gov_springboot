package com.korit.springboot.controller;

import com.korit.springboot.config.BeanConfig;
import com.korit.springboot.dto.CreateUserRequestDto;
import com.korit.springboot.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 1

//    private String username = "test12";
//    private String password = "1234";

//    @GetMapping("/info")
//    public ResponseEntity<String> printInfo() {
//        return ResponseEntity.ok("UserController!!!");
//    }
//
//    @GetMapping("/users")
//    public Map<String, String> getUsers(HttpServletResponse response) {
//        response.setStatus(400);
//        response.setContentType("application/json");
//        return (Map.of("username", username, "password", password));
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity <Map<String, String>> getUsers(HttpServletResponse response) {
//        return ResponseEntity.status(HttpStatus.OK).body(Map.of("username", username, "password", password));
//    }

@RestController
@RequiredArgsConstructor
public class UserController {

    // @Autowired
    private final UserService userService;



    @PostMapping("/api/users")
    public ResponseEntity<Map<String, Integer>> create(@Valid @RequestBody CreateUserRequestDto dto)  {
        userService.duplicatedUsername(dto.getUsername());
        int createdUserId = userService.createUser(dto);
        return ResponseEntity.ok(Map.of("createdUserId", createdUserId));
    }


}
