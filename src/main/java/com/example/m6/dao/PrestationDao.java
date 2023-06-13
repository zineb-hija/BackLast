package com.example.m6.dao;

import com.example.m6.bean.Prestation;
import com.example.m6.bean.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestationDao extends JpaRepository<Prestation, Long> {
    int deleteByHopital(String hopital);
    Prestation findByHopital(String hopital);
    int deleteByService(String service);
    Prestation findByService(String service);

}
