package com.beyond.basic.b2_board.post.service;

import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.author.repository.AuthorRepository;
import com.beyond.basic.b2_board.post.dtos.PostDetailDto;
import com.beyond.basic.b2_board.post.dtos.PostListDto;
import com.beyond.basic.b2_board.post.dtos.PostCreateDto;
import com.beyond.basic.b2_board.post.domain.Post;
import com.beyond.basic.b2_board.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;
    @Autowired
    public PostService(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    public void save(PostCreateDto dto){
//        Author author = authorRepository.findByEmail(dto.getAuthorEmail()).orElseThrow(()-> new EntityNotFoundException("entity is not found"));
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Author author = authorRepository.findByEmail(email).orElseThrow(()-> new EntityNotFoundException("entity is not found"));
        postRepository.save(dto.toEntity(author));
    }
    @Transactional(readOnly = true)
    public PostDetailDto findById(Long id){
        Post post =  postRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("post is not found"));
//        PostDetailDto dto = PostDetailDto.fromEntity(post,author);
        PostDetailDto dto = PostDetailDto.fromEntity(post);
        return dto;


    }
    @Transactional(readOnly = true)
    public List<PostListDto> findAll(){
//        List<Post> postList = postRepository.findAllByDelYn("N");
        List<Post> postList = postRepository.findAllFetchInnerJoin();
        List<PostListDto> postListDtoList = new ArrayList<>();
        for (Post p : postList){
            PostListDto dto = PostListDto.fromEntity(p);
            postListDtoList.add(dto);
        }
        return postListDtoList;
    }

    public void deletePost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("post is not found"));
        post.deletePost();

    }

}
