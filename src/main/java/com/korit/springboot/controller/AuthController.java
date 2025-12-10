package com.korit.springboot.controller;

import com.korit.springboot.dto.SigninRequestDto;
import com.korit.springboot.dto.SignupRequestDto;
import com.korit.springboot.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//AuthenticationController
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequestDto dto) {
        authService.duplicatedUsername(dto.getUsername());
        authService.authUserId(dto);
        return ResponseEntity.ok("회원가입완료 !!!");
    }

    @PostMapping("/api/auth/signin")
    public ResponseEntity<Map<String, String>> signin(@Valid @RequestBody SigninRequestDto dto) {
        return ResponseEntity.ok(Map.of("accessToken",authService.signin(dto)));
    }
}
