package com.example.m6.security.service.admin.impl;


import com.example.m6.security.bean.Administrateur;
import com.example.m6.security.bean.Role;
import com.example.m6.security.bean.User;
import com.example.m6.security.dao.UserDao;
import com.example.m6.security.jwt.JwtResponse;
import com.example.m6.security.jwt.JwtUtil;
import com.example.m6.security.service.RoleService;
import com.example.m6.security.service.admin.facade.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

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

    // Save Admin
    @Override
    public Administrateur save(Administrateur admin) {
        User loadedUser = userDao.findByUsername(admin.getUsername());
        if (loadedUser != null) return null;
        else {
            Role role;
            if (admin.getRole().equalsIgnoreCase("ADMIN")) {
                role = roleService.findByAuthority("ROLE_ADMIN");
                if (role == null) role = new Role("ROLE_ADMIN");
            } else {
                return null;
            }

            Collection<Role> roles = new ArrayList<>();
            roles.add(role);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            admin.setAuthorities(roles);
            roleService.save(role);
            userDao.save(admin);
            return admin;
        }
    }
    // End Save Admin

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    @Override
    public Collection<User> findByRole(String role) {
        return userDao.findByRole(role);
    }

    @Override
    @Transactional
    public int deleteByUsername(String username) {
        User loadedUser = findByUsername(username);

        if (loadedUser == null) {
            return -1;
        } else {
            userDao.delete(loadedUser);
            return 1;
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
