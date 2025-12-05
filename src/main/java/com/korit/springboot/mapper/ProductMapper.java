package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    int productInsert
            (@Param("product_name") String product_name,
             @Param("size") String size,
             @Param("price") int price);

    List<String> findAllName();
}
