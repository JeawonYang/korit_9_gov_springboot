package com.korit.springboot.exception;

import com.korit.springboot.dto.ValidErrorResponseDto;
import lombok.Getter;

public class DuplicatedException extends RuntimeException {
    @Getter
    private ValidErrorResponseDto validErrorResponseDto;


    public DuplicatedException(String message, String fieldName) {
        super(message);
        this.validErrorResponseDto = new ValidErrorResponseDto(fieldName, message);
    }
}
