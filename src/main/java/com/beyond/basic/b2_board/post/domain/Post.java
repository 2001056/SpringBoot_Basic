package com.beyond.basic.b2_board.post.domain;

import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
@Builder
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 3000)
    private String contents;
    private String category;
//    @Column(nullable = false)
//    private Long authorId;
//    private String authorEmail;

//    ManyToOne을 통해 fk설정(author_id)컬럼
//    ManyToone을 통해 author_id 컬럼으로 autho객체 조회 자동 생성
//    fetch lazy(지연로딩) : author객체를 사용하지 않는 한 , author객체 생성X(서버부하감소)
    @ManyToOne(fetch =  FetchType.LAZY)
//    ManyToOne 어노테이션만 추가하더라도,아래 옵션이 생략 돼 있는것. fk 를 설정하지 않고자 할 때,NO_CONSTRAINT 설정
    @JoinColumn(name ="author_id",foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),nullable = false)
    private Author author;
    @Builder.Default
    private String delYn="N";


    public void deletePost(){

        this.delYn = "Y";
    }
}
