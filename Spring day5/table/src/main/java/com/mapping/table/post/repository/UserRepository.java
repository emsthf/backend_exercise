package com.mapping.table.post.repository;

import com.mapping.table.post.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
