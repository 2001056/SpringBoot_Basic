package com.beyond.basic.b2_board.dtos;

import com.beyond.basic.b2_board.author.domain.Author;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorLoginDto {
    private String email;
    private String password;

}
