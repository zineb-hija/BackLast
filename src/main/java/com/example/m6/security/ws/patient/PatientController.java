package com.example.m6.security.ws.patient;


import com.example.m6.security.bean.Patient;
import com.example.m6.security.bean.User;
import com.example.m6.security.jwt.JwtResponse;
import com.example.m6.security.service.admin.facade.AdminService;
import com.example.m6.security.service.patient.facade.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/api/v1/patient")
@CrossOrigin("*")
public class PatientController {
    @PostMapping("/")
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @PostMapping("/sign-in")
    public JwtResponse signIn(@RequestBody User user) {
        return patientService.signIn(user);
    }

    @GetMapping("/username/{username}")
    public User loadUserByUsername(@PathVariable String username) {
        return patientService.loadUserByUsername(username);
    }


    @Autowired
    private PatientService patientService;
}
