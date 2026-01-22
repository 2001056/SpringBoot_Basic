package com.beyond.basic.b2_board.dtos;

import com.beyond.basic.b2_board.author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorDetailDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int postCount;


    public static AuthorDetailDto fromEntity(Author author){
        return AuthorDetailDto.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .password(author.getPassword())
                .postCount(author.getPostList().size())
                .build();
    }
}
