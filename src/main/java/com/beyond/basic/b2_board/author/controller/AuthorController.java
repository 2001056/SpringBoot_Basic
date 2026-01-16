package com.beyond.basic.b2_board.author.controller;


import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.author.service.AuthorService;
import com.beyond.basic.b2_board.dtos.AuthorCreateDto;
import com.beyond.basic.b2_board.dtos.AuthorDetailDto;
import com.beyond.basic.b2_board.dtos.AuthorListDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    AuthorService authorService;
    public AuthorController(){
        this.authorService = new AuthorService();
    }

    @PostMapping("/create")
    public String create(@RequestBody AuthorCreateDto dto){
        authorService.save(dto);
        return "OK";

    }

    @GetMapping("/list")
    public List<AuthorListDto> findAll(){
        List<AuthorListDto> dtoList = authorService.findAll();
        return dtoList;


    }
    @GetMapping("/{id}")
    public AuthorDetailDto findById(@PathVariable Long id){
        AuthorDetailDto dto = authorService.findById(id);
        return dto;

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        System.out.println(id);
        return null;
    }
//
//    @PostMapping("/create")
//    @ResponseBody
//    public String aCreate(@RequestBody Author author){
//        System.out.println(author);
//        return "OK";
//
//    }
//    @GetMapping("/list")
//    @ResponseBody
//    public String aList(@RequestBody List<Author> authorList){
//        System.out.println(authorList);
//        return "null";
//    }
//
//    @GetMapping("/list/{inputId}")
//    @ResponseBody
//    public String aDetail(@PathVariable Long inputId){
//        System.out.println(inputId);
//        return null;
//    }
//
//    @DeleteMapping("/delete/{inputId}")
//    @ResponseBody
//    public String aDelete(@PathVariable Long inputId){
//        System.out.println(inputId);
//        return "OK";
//    }
//

}
