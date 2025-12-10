package com.korit.springboot.mapper;

import com.korit.springboot.entity.AuthEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {
    int insert (AuthEntity authEntity);
    AuthEntity findByUsername(@Param("username")String username);
    AuthEntity findById(@Param("userId")int userId);
}
