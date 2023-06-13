package com.example.m6.service.facade;

import com.example.m6.bean.Voie;

import java.util.List;

public interface VoieService {
    Voie findById(Long id);

    int deleteById(Long id);

    Voie save(Voie voie);
    List<Voie> findAll();
}
