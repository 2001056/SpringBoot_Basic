package com.beyond.basic.b2_board.post.dtos;

import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCreateDto {

    private String title;
    private String contents;
    private String category;
    private String authorEmail;

    public Post toEntity(Author author){
        return Post.builder()
                .title(this.getTitle())
                .contents(this.getContents())
                .category(this.getCategory())
                .author(author)
//                .delYn("N")
                .build();
    }

}
