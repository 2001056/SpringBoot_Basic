package com.beyond.basic.b2_board.author.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
//빌더패턴은 AllArgs생성자 기반으로 동작
@Builder
public class Author {
    private Long id;
    private String name;
    private String email;
    private String password;
}
