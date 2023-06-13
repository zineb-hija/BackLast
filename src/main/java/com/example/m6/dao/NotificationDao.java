package com.example.m6.dao;

import com.example.m6.bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {


}
