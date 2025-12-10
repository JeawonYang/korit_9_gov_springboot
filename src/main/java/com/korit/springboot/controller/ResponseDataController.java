package com.korit.springboot.controller;

import com.korit.springboot.dto.RespJsonDto;
import com.korit.springboot.dto.RespJsonDto2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ResponseDataController {

    // 응답 데이터 - 문자열 (Text-Plane 반환)
    @GetMapping("/resp/data1")
    public ResponseEntity<String> getString () {
        return ResponseEntity.ok("문자열 응답");
    }

    // 응답 데이터 - Map (JSON 반환)
    @GetMapping("/resp/data2")
    public ResponseEntity <Map<String, String>> getString1 () {
        return ResponseEntity.ok(Map.of("Key1", "Value1", "Key2", "Value2"));
    }

    // 응답 데이터 - List (JSON 반환)
    @GetMapping("/resp/data3")
    public ResponseEntity <List<Integer>> getString2 () {
//        return ResponseEntity.ok(List.of("a", "b", "c"));
        return ResponseEntity.ok(List.of(1, 2, 3, 4));
    }

    // 응답 데이터 - 객체 (JSON 반환)
    @GetMapping("/resp/data4")
    public ResponseEntity <RespJsonDto> getObject() {
        RespJsonDto respJsonDto = new RespJsonDto();
        respJsonDto.setName("양재원");
        respJsonDto.setEmail("yjy5784@daum.net");
        respJsonDto.setStrs(List.of("점", "심", "메", "뉴", "추", "천"));
        respJsonDto.setRespJsonDto2(new RespJsonDto2());
        return ResponseEntity.ok(respJsonDto);
    }

    // 응답 데이터 - file 어렵
    @GetMapping("/resp/data5")
    public ResponseEntity <Resource> download(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
    // 응답 데이터 - file (UTF-8) 어렵
    @GetMapping("/resp/data6")
    public ResponseEntity <Resource> downloadUTF8(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);

        String contentDisPosition = ContentDisposition.builder("attachment")
                .filename(filename, StandardCharsets.UTF_8)
                .build().toString();

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisPosition)
                .body(resource);
    }
}
