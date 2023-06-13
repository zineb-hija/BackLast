package com.example.m6.service.impl;

import com.example.m6.bean.TypeRemplissage;
import com.example.m6.dao.TypeRemplissageDao;
import com.example.m6.service.facade.TypeRemplissageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRemplissageServiceImpl implements TypeRemplissageService {
    @Autowired
    private TypeRemplissageDao typeRemplissageDao;

    @Override
    public TypeRemplissage findById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<TypeRemplissage> findAll() {
        return typeRemplissageDao.findAll();
    }

    public TypeRemplissage save(TypeRemplissage typeRemplissage) {
        TypeRemplissage typ = null;

        if (findById(typeRemplissage.getId()) == null) {
            typ = typeRemplissageDao.save(typeRemplissage);
        }
        return typ;

    }
}
