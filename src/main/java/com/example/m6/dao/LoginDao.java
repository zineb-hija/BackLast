package com.example.m6.dao;

import com.example.m6.bean.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<Login, Long> {
    Login findByIid(Long iid);

    int deleteByIid(Long iid);

    boolean existsByIid(Long iid);
}
