package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserRequestDto;
import com.korit.springboot.dto.SigninRequestDto;
import com.korit.springboot.dto.SignupRequestDto;
import com.korit.springboot.entity.AuthEntity;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicatedException;
import com.korit.springboot.jwt.JwtTokenProvider;
import com.korit.springboot.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.sasl.AuthenticationException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthMapper authMapper;

    @Transactional(rollbackFor = Exception.class)
    public int authUserId(SignupRequestDto dto) {
        AuthEntity authEntity = dto.toEntity(passwordEncoder);
        authMapper.insert(dto.toEntity(passwordEncoder));
        return authEntity.getUserId();
    }

    public void duplicatedUsername(String username) {
        AuthEntity foundUser = authMapper.findByUsername(username);
        if (foundUser != null) {
            throw new DuplicatedException("username", "이미 존재하는 사용자이름입니다.");
        }
    }
    public String signin(SigninRequestDto dto) {
       final String username = dto.getUsername();
       final String password = dto.getPassword();
       final String defaultMessage = "사용자 정보를 확인하세요.";
       AuthEntity foundUser = authMapper.findByUsername(username);
       if (foundUser == null) {
           throw new UsernameNotFoundException(defaultMessage);
       }
       if (!passwordEncoder.matches(password, foundUser.getPassword())) {
           throw new BadCredentialsException(defaultMessage);
       }
       // 토큰 생성
        final String accessToken = jwtTokenProvider.createAccessToken(foundUser);


        return accessToken;
    }
}
