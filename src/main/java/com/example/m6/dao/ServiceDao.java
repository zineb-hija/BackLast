package com.example.m6.dao;

import com.example.m6.bean.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServiceDao extends JpaRepository<Service, Long> {
    int deleteByLibelle(String libelle);
    Service findByLibelle(String libelle);
}
