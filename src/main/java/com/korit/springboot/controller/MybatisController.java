package com.korit.springboot.controller;

import com.korit.springboot.dto.RequestStudyInsertDto;
import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MybatisController {

    @Autowired
    private StudyMapper studyMapper;

    // insert 하는방법
    @PostMapping("/mybatis/study")
    public ResponseEntity <?> insert(@RequestParam String name,@RequestParam int age) {
        studyMapper.insert(name, age);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mybatis/study")
    public ResponseEntity <List<Map<String,Object>>> getAll() {
        return ResponseEntity.ok(studyMapper.findAll());
    }

    @GetMapping("/mybatis/study/names")
    public ResponseEntity <List<String>> getNames() {
        return ResponseEntity.ok(studyMapper.findAllName());
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
