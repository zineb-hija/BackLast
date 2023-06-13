package com.example.m6.ws;

import com.example.m6.bean.Login;
import com.example.m6.service.facade.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/login")
public class LoginWs {
    @Autowired
    private LoginService loginService;

    @GetMapping("/iid/{iid}")
    public Login findByIid(@PathVariable Long iid) {
        return loginService.findByIid(iid);
    }

    @Transactional
    @DeleteMapping("/iid/{iid}")
    public int deleteByIid(@PathVariable Long iid) {
        return loginService.deleteByIid(iid);
    }

    @PostMapping("/")
    public Login save(@RequestBody Login login) {
        return loginService.save(login);
    }

    public List<Login> findAll() {
        return loginService.findAll();
    }
}
