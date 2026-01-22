package com.beyond.basic.b2_board.post.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 3000)
    private String contents;
    private String category;
    @Column(nullable = false)
    private String authorEmail;
    private String delYn;

    public void deletePost(){
        this.delYn = "Y";
    }
}
