package com.beyond.basic.b2_board.author.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
//빌더패턴은 AllArgs생성자 기반으로 동작
@Builder
//JPA에게 Entity관리를 위임하기 위한 어노테이션
@Entity
public class Author {
    @Id //pk설정
//    IDENTITY : auto_increment설정. auto:id생성전략을 jpa에게 자동설정하도록위임
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long -> bigint, String -> varchar
    private Long id;
//    변수명이 컬럼명으로 그대로 생성. camel case는 언더스코어로 변경 예)nickName -> nick_name
    private String name;
//    길이를 varchar(50,디폴트= varchar(255)) 유니크 , 낫널 설정
    @Column(length = 50,unique = true,nullable = false)
    private String email;
//    @Column(name="pw") : 컬럼명의 변경이 가능하나, 일반적으로 일치시킴.
//    @Setter
    private String password;

    public void updatePassword(String password){
        this.password = password;
    }
}
