package com.beyond.basic.b2_board.post.controller;

import com.beyond.basic.b2_board.post.dtos.PostDetailDto;
import com.beyond.basic.b2_board.post.dtos.PostListDto;
import com.beyond.basic.b2_board.post.dtos.PostPostingDto;
import com.beyond.basic.b2_board.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/post/create")
    public ResponseEntity<?> create(@RequestBody @Valid PostPostingDto dto){
        postService.save(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("OK");
    }
    @GetMapping("/posts")
    public List<PostListDto> findAll(){
        List<PostListDto> dtoList = postService.findAll();
        return dtoList;
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        PostDetailDto dto = postService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
