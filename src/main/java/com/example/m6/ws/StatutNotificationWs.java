package com.example.m6.ws;

import com.example.m6.bean.StatutNotification;
import com.example.m6.service.facade.StatutNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statutNotification")
public class StatutNotificationWs {
    @Autowired
    private StatutNotificationService statutNotificationService;

    @GetMapping("/code/{code}")
    public StatutNotification findByCode(@PathVariable String code) {
        return statutNotificationService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/code/{code}")

    public int deleteByCode(@PathVariable String code) {
        return statutNotificationService.deleteByCode(code);
    }

    @PostMapping("/")
    public StatutNotification save(@RequestBody StatutNotification statutNotification) {
        return statutNotificationService.save(statutNotification);
    }

    public List<StatutNotification> findAll() {
        return statutNotificationService.findAll();
    }
}
