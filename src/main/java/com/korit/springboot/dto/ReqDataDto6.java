package com.korit.springboot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReqDataDto6 {
    private String name;
    private int age;
    private String address;
    private String phone;
}
