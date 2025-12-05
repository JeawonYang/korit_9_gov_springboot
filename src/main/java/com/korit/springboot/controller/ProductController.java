package com.korit.springboot.controller;

import com.korit.springboot.dto.RequestProductInsertDto;
import com.korit.springboot.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/mybatis/product")
    public ResponseEntity <?> Productinsert(@RequestBody RequestProductInsertDto dto) {
        productMapper.productInsert(dto.getProduct_name(), dto.getSize(), dto.getPrice());
        return ResponseEntity.ok().build();
    }
}
