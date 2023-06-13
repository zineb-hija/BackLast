package com.example.m6.service.impl;

import com.example.m6.bean.Departement;
import com.example.m6.bean.Dossier;
import com.example.m6.dao.DossierDao;
import com.example.m6.service.facade.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DossierServiceImpl implements DossierService {
    @Autowired
    private DossierDao dossierDao;


    @Override
    public Dossier findById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }
    @Override

    public List<Dossier> findAll() {
        return dossierDao.findAll();
    }

    @Override
    public int save(Long id) {
        return 0;
    }

    public Dossier save(Dossier dossier) {
        Dossier dos = null;

        if (findById(dossier.getId()) == null) {
            dos = dossierDao.save(dossier);
        }
        return dos;

    }

}
