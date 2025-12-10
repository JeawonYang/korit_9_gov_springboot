package com.korit.springboot.controller;

import com.korit.springboot.dto.ReqFormDataDto4;
import com.korit.springboot.dto.ReqJsonDto2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class RequestDataController2 {

    // POST 요청 데이터 받는 방법 1 - Map을 통해 JSON 데이터 받는 방법
    @PostMapping("/req/data1")
    public ResponseEntity<?> reqPost1(@RequestBody Map<String, Object> data){
        System.out.println(data);
        System.out.println(data.get("additionalProp2"));
        return ResponseEntity.ok().build();
    }
    // POST 요청 데이터 받는 방법 2 - DTO를 통해 JSON 데이터 받는 방법
    @PostMapping("/req/data2")
    public ResponseEntity<Map<String, String>> reqPost2(@RequestBody ReqJsonDto2 data){
        System.out.println(data);
        return ResponseEntity.ok().build();
    }

    // POST 요청 데이터 받는 방법 3 - 파일 데이터 받는 방법
    // <input type="file"> 로 전송된 파일을 Spring이 MultipartFile 객체로 변환하여 제공함
    // 파일 업로드를 위해서는 요청 Content-Type이 반드시 multipart/form-data 이어야 함
    @PostMapping(value = "/req/data3", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> reqPost3(@RequestPart MultipartFile file){
        System.out.println(file.getOriginalFilename());
        return ResponseEntity.ok().build();
    }

    // POST 요청 데이터 받는 방법 4 - 파일 데이터 받는 방법
    @PostMapping(value = "/req/data4", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> reqPost4(ReqFormDataDto4 dto){
        System.out.println(dto);
        System.out.println(dto.getFile().getOriginalFilename());
        return ResponseEntity.ok().build();
    }

    // POST 요청 데이터 받는 방법 5 - 여러개의 파일 데이터를 받는 방법
    @PostMapping(value = "/req/data5", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> reqPost5(@RequestPart List<MultipartFile> files){
        files.forEach(file -> System.out.println(file.getOriginalFilename()));
        return ResponseEntity.ok().build();
    }

    // PUT 요청 데이터 받는 방법 1 - JSON 데이터만 보통 사용 (JSON 관련은 RequestBody 어노테이션 사용해야함)
    // PUT 요청은 전체수정
    @PutMapping("/req/data1/{id}")
    public ResponseEntity<?> reqPut1 (@PathVariable int id, @RequestBody ReqJsonDto2 dto) {
        System.out.println(dto);
        return ResponseEntity.ok().build();
    }

    // PATCH 요청 데이터 받는 방법 1 - JSON 데이터만 보통 사용
    // PATCH 요청 : 부분수정
    @PatchMapping("/req/data1/{id}")
    public ResponseEntity<?> reqPatch (@PathVariable int id, @RequestBody ReqJsonDto2 dto) {
        System.out.println(dto);
        return ResponseEntity.ok().build();
    }

    // DELETE 요청 데이터 받는 방법 1 - ID만 사용 (보통)
    @DeleteMapping("/req/data1/{id}")
    public ResponseEntity<?> reqDelete (@PathVariable int id, @RequestBody Map <String, Object> name) {
        System.out.println(id);
        System.out.println(name);
        return ResponseEntity.ok().build();
    }
}

