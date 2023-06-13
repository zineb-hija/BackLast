package com.example.m6.security.service.patient.facade;


import com.example.m6.security.bean.Administrateur;
import com.example.m6.security.bean.Patient;
import com.example.m6.security.bean.User;
import com.example.m6.security.jwt.JwtResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PatientService extends UserDetailsService {
    User loadUserByUsername(String username);

    Patient save(Patient patient);


    //    sign Up user
    JwtResponse signIn(User user);
}
