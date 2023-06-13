package com.example.m6.service.facade;

import com.example.m6.bean.Login;

import java.util.List;

public interface LoginService {
    Login findByIid(Long iid);

    int deleteByIid(Long iid);

    Login save(Login login);
    List<Login> findAll();
}
