package com.beyond.basic.b2_board.author.controller;

import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.dtos.AuthorDetailDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//ResponseEntity :
@RestController
@RequestMapping("/response_entity")
public class ResponseEntityController {

//    case1. @ResponseStatus 어노테이션사용 : 상황에 따른 분기처리의 어려움
    @GetMapping("/annotation")
    @ResponseStatus(HttpStatus.CREATED)
    public String annotation(){
        return "OK";
    }

//    ResponseEntity 방식
    @GetMapping("/method1")
    public ResponseEntity<String> method1(){
        return new ResponseEntity<>("OK",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/method2")
    public ResponseEntity<?> method2(){
        return new ResponseEntity<>("OK",HttpStatus.NOT_FOUND);
    }

//    가장 추천하는 방식
//    ResponseEntity, ?(any), 빌더패턴을 사용하여 상태코드,header,body를 쉽게 생성
    @GetMapping("/method3")
    public ResponseEntity<?> method3(){
        AuthorDetailDto dto = AuthorDetailDto.builder()
                .id(1L)
                .name("hong10")
                .email("hong@naver.com")
                .password("12345")
                .build();
        return ResponseEntity
                .status(HttpStatus.CREATED)
//                .header("Contetnt-Type","application/json")
                .body(dto);
    }


    @GetMapping("/method4")
    public ResponseEntity<?> method4(){
        AuthorDetailDto dto = AuthorDetailDto.builder()
                .id(1L)
                .name("hong10")
                .email("hong@naver.com")
                .password("12345")
                .build();
        return ResponseEntity.ok(dto);

    }
}
