package com.beyond.basic.b2_board.post.repository;

import com.beyond.basic.b2_board.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByDelYn(String delYn);

    List<Post> findAllByAuthorIdAndDelYn(Long authorId,String DelYn);

//    jqpl을 활용한 일반 inner join : n+1문제 해결X
//    jqpl과 raw쿼리의 차이
//    1.jqpl을 사용한 inner join시 별도의 on조건 필요x
//    2.jqple은 컴파일타임에 에러를 check
//    순수쿼리 : selet p.* from post p inner join author a on a.id = p.author_id
    @Query("select p from Post p inner join p.author")
    List<Post> findAllInnerJoin();
//    jqpl을 활용한 inner join(fetch) : n+1문제 해결O
@Query("select p from Post p inner join fetch p.author")
List<Post> findAllFetchInnerJoin();

}
