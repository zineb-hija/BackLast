package com.example.m6.service.facade;

import com.example.m6.bean.TypeRemplissage;

import java.util.List;

public interface TypeRemplissageService {
    TypeRemplissage findById(Long id);

    int deleteById(Long id);

    TypeRemplissage save(TypeRemplissage typeRemplissage);
    List<TypeRemplissage> findAll();
}
