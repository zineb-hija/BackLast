package com.example.m6.dao;

import com.example.m6.bean.StatutNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutNotificationDao extends JpaRepository<StatutNotification, Long> {
}
