package com.example.m6.security.service.patient.impl;


import com.example.m6.security.bean.Administrateur;
import com.example.m6.security.bean.Patient;
import com.example.m6.security.bean.Role;
import com.example.m6.security.bean.User;
import com.example.m6.security.dao.UserDao;
import com.example.m6.security.jwt.JwtResponse;
import com.example.m6.security.jwt.JwtUtil;
import com.example.m6.security.service.RoleService;
import com.example.m6.security.service.patient.facade.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    // Sign in Users Method
    @Override
    public JwtResponse signIn(User user) {
        final Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User loadUserByUsername = loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(loadUserByUsername);
        JwtResponse response = new JwtResponse(token);
        return response;
    }
    // End Sign in Users Method

    // Save Patient
    @Override
    public Patient save(Patient patient) {
        User loadedUser = userDao.findByUsername(patient.getUsername());
        if (loadedUser != null) return null;
        else {
            Role role;
            if (patient.getRole().equalsIgnoreCase("PATIENT")) {
                role = roleService.findByAuthority("ROLE_PATIENT");
                if (role == null) role = new Role("ROLE_PATIENT");
            } else {
                return null;
            }

            Collection<Role> roles = new ArrayList<>();
            roles.add(role);
            patient.setPassword(passwordEncoder.encode(patient.getPassword()));
            patient.setAuthorities(roles);
            roleService.save(role);
            userDao.save(patient);
            return patient;
        }
    }
    // End Save Patient


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
}
