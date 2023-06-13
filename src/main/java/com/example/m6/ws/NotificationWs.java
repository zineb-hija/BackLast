package com.example.m6.ws;

import com.example.m6.bean.Notification;
import com.example.m6.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationWs {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/id/{id}")

    public Notification findById(@PathVariable Long id) {
        return notificationService.findById(id);
    }

    @Transactional
    @DeleteMapping("/id/{id}")

    public int deleteById(@PathVariable Long id) {
        return notificationService.deleteById(id);
    }

    @PostMapping("/")

    public Notification save(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    public List<Notification> findAll() {
        return notificationService.findAll();
    }
}
