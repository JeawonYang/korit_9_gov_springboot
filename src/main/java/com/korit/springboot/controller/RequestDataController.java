package com.korit.springboot.controller;

import com.korit.springboot.dto.ReqDataDto6;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin
@RestController
public class RequestDataController {

    // Get /req/data 메서드명 reqGet

    // Get 요청 파라미터 받는 방법 1 (서블릿 받는방법 자료의 형변환도 직접해줘야함)
//  @CrossOrigin("http://localhost:5173")
    @GetMapping ("/req/data1")
    public ResponseEntity<Map<String, String>> reqGet1(HttpServletRequest request){
        String name = request.getParameter("a");
        int age = Integer.parseInt(request.getParameter("b"));
        System.out.println("data1 : " + name);
        System.out.println("data1 : " + age);
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 2 (어노테이션 사용해서 key value 받아오기)
    @GetMapping ("/req/data2")
    public ResponseEntity<Map<String, String>> reqGet2(
            @RequestParam("a") String name,
            @RequestParam("b")int age){
        System.out.println("data2 : " + name);
        System.out.println("data2 : " + age);
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 3 - 변수명과 파라미터 명이 일치하면 @RequestParam의 이름을 생략할 수 있다.
    @GetMapping ("/req/data3")
    public ResponseEntity<Map<String, String>> reqGet3(
            @RequestParam String name,
            @RequestParam int age){
        System.out.println("data3 : " + name);
        System.out.println("data3 : " + age);
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 4 - 해당 파라미터를 필수 항목으로 설정할 수 있다. (기본 값 True)
    // int 는 null을 반환할 수 없으므로 Integer로 변환해서 null 값을 받아야 500 Error이 안뜸
    // 정수 자료형의 파라미터가 필수가 아닐때 Integer 자료형을 사용해야한다.
    @GetMapping ("/req/data4")
    public ResponseEntity<Map<String, String>> reqGet4(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age){
        System.out.println("data4 : " + name);
        System.out.println("data4 : " + age);
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 5
    @GetMapping ("/req/data5")
    public ResponseEntity<Map<String, String>> reqGet5(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String address,
            @RequestParam String phone){
        System.out.println("data5 : " + name);
        System.out.println("data5 : " + age);
        System.out.println("data5 : " + address);
        System.out.println("data5 : " + phone);
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 6 - 파라미터가 많아졌을 때 DTO로 처리하는 방법
    @GetMapping ("/req/data6")
    public ResponseEntity<Map<String, String>> reqGet6(ReqDataDto6 dto){
        System.out.println("data6 : " + dto.getName());
        System.out.println("data6 : " + dto.getAge());
        System.out.println("data6 : " + dto.getAddress());
        System.out.println("data6 : " + dto.getPhone());
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 7 - 주소에서 값 가져오기
    @GetMapping ("/req/{path}/data7/{id}")
    public ResponseEntity<Map<String, String>> reqGet7(
            @PathVariable int id,
            @PathVariable String path,
            ReqDataDto6 dto){
        System.out.println("data6 : " + id);
        System.out.println("data6 : " + path);
        System.out.println("data6 : " + dto.getName());
        System.out.println("data6 : " + dto.getAge());
        System.out.println("data6 : " + dto.getAddress());
        System.out.println("data6 : " + dto.getPhone());
        return ResponseEntity.ok().build();
    }
}

