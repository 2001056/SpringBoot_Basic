package com.beyond.basic.b2_board.post.service;

import com.beyond.basic.b2_board.author.repository.AuthorRepository;
import com.beyond.basic.b2_board.post.dtos.PostDetailDto;
import com.beyond.basic.b2_board.post.dtos.PostListDto;
import com.beyond.basic.b2_board.post.dtos.PostPostingDto;
import com.beyond.basic.b2_board.post.domain.Post;
import com.beyond.basic.b2_board.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void save(PostPostingDto dto){
        if (authorRepository.findByEmail(dto.getAuthorEmail()).isEmpty()){
            throw new EntityNotFoundException("존재하지않는 사용자");
        }
        Post post = dto.toEntity();
        postRepository.save(post);
    }
    @Transactional(readOnly = true)
    public PostDetailDto findById(Long id){
        Optional<Post> optPost= postRepository.findById(id);
        Post post = optPost.orElseThrow(()-> new EntityNotFoundException("entity is not found"));

        PostDetailDto dto = PostDetailDto.fromEntity(post);
        return dto;
    }
    @Transactional(readOnly = true)
    public List<PostListDto> findAll(){
        List<Post> posts = postRepository.findByDelYn("N");
        return posts.stream()
                .map(a-> PostListDto.fromEntity(a))
                .collect(Collectors.toList());
    }

    public void deletePost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("entity is not found"));
        post.deletePost();

    }

}
