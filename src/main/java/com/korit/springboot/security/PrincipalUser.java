package com.korit.springboot.security;

import com.korit.springboot.entity.AuthEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class PrincipalUser implements UserDetails {
    @Getter
    private final AuthEntity authEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authEntity.getUserRoleEntities()
                .stream()
                .map(userRoleEntity ->
                        new SimpleGrantedAuthority(userRoleEntity
                                .getRoleEntity()
                                .getRoleName()))
                .toList();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return authEntity.getUsername();
    }

    public int getUserId() {
        return authEntity.getUserId();
    }
}
