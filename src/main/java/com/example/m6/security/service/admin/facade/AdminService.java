package com.example.m6.security.service.admin.facade;


import com.example.m6.security.bean.Administrateur;
import com.example.m6.security.bean.User;
import com.example.m6.security.jwt.JwtResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

public interface AdminService extends UserDetailsService {
    User findByUsername(String username);

    Collection<User> findByRole(String role);

    int deleteByUsername(String username);

    Administrateur save(Administrateur admin);

    List<User> findAll();

    //    sign Up user
    JwtResponse signIn(User user);
}
