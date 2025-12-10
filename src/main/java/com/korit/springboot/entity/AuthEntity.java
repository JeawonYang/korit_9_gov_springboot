package com.korit.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthEntity {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;

    private List<UserRoleEntity> userRoleEntities;
}
