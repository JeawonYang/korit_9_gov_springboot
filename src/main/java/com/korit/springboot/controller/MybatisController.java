package com.korit.springboot.controller;

import com.korit.springboot.dto.RequestStudyInsertDto;
import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private StudyMapper studyMapper;

    // insert 하는방법
    @PostMapping("/mybatis/study")
    public ResponseEntity <?> insert() {
        studyMapper.insert("name", Integer.parseInt("age"));
        return ResponseEntity.ok().build();
    }

    // Map 으로 insert 하는방법
//    @PostMapping("/mybatis/study")
//    public ResponseEntity <?> insert(@RequestBody Map<String, Object> reqMap) {
//        studyMapper.insert((String) reqMap.get("name"), (Integer)reqMap.get("age"));
//        return ResponseEntity.ok().build();
//    }

    // Dto로 insert 하는방법
//    @PostMapping("/mybatis/study")
//    public ResponseEntity <?> insert(@RequestBody RequestStudyInsertDto dto) {
//        studyMapper.insert(dto.getName(), dto.getAge());
//        return ResponseEntity.ok().build();
//    }
}
