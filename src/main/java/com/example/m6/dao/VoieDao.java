package com.example.m6.dao;

import com.example.m6.bean.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoieDao extends JpaRepository<Voie, Long> {

}
