package com.mapping.table.post.repository;

import com.mapping.table.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // id로 Long을 쓰기 때문에 Integer가 아닌 Long을 사용한다
}
