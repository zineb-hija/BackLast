package com.example.m6.security.ws.admin;


import com.example.m6.security.bean.Administrateur;
import com.example.m6.security.bean.User;
import com.example.m6.security.jwt.JwtResponse;
import com.example.m6.security.service.admin.facade.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/admin")
@CrossOrigin("*")
public class AdminController {
    @PostMapping("/")
    public Administrateur save(@RequestBody Administrateur admin) {
        return userService.save(admin);
    }

    @PostMapping("/sign-in")
    public JwtResponse signIn(@RequestBody User user) {
        return userService.signIn(user);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }

    @GetMapping("/role/{role}")
    public Collection<User> findByRole(@PathVariable String role) {
        return userService.findByRole(role);
    }

    @Autowired
    private AdminService userService;
}
