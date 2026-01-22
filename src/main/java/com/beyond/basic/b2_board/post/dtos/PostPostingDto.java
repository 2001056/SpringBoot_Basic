package com.beyond.basic.b2_board.post.dtos;

import com.beyond.basic.b2_board.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPostingDto {

    @NotBlank
    private String title;
    @NotBlank
    private String contents;
    @NotBlank
    private String category;
    @NotBlank
    private String authorEmail;

    public Post toEntity(){
        return Post.builder()
                .title(this.title)
                .contents(this.contents)
                .category(this.category)
                .authorEmail(this.authorEmail)
                .delYn("N")
                .build();
    }
}
