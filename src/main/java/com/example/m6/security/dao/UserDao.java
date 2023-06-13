package com.example.m6.security.dao;

import com.example.m6.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User deleteByUsername(String username);

    Collection<User> findByRole(String role);
}