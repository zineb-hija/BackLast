package com.example.m6.security.service.responsable.facade;


import com.example.m6.security.bean.Patient;
import com.example.m6.security.bean.Responsable;
import com.example.m6.security.bean.User;
import com.example.m6.security.jwt.JwtResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ResponsableService extends UserDetailsService {
    Responsable save(Responsable responsable);


    //    sign Up user
    JwtResponse signIn(User user);
}
