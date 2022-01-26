package com.security.demo.repository;

import com.security.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// CRUD 함수를 JpaRepository가 들고 있음
// @Reposotory라는 어노테이션이 없어도 Ioc가능 이유는 JpaRepository를 상속했기 때문
public interface UserRepository extends JpaRepository<User, Integer>{

    // findBy 규칙 -> Username 문법
    // select * from user where username = ?
    public User findByUsername(String username); // Jpa query methods

    // select * from user where email = ?
    // public User findByEamil();
}
