package com.example.m6.security.ws.responsable;


import com.example.m6.security.bean.Responsable;
import com.example.m6.security.bean.User;
import com.example.m6.security.jwt.JwtResponse;
import com.example.m6.security.service.admin.facade.AdminService;
import com.example.m6.security.service.responsable.facade.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/api/v1/responsable")
@CrossOrigin("*")
public class ResponsableController {
    @PostMapping("/")
    public Responsable save(@RequestBody Responsable responsable) {
        return responsableService.save(responsable);
    }

    @PostMapping("/sign-in")
    public JwtResponse signIn(@RequestBody User user) {
        return responsableService.signIn(user);
    }

    @Autowired
    private ResponsableService responsableService;
}
