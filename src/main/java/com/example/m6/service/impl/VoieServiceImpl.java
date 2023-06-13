package com.example.m6.service.impl;

import com.example.m6.bean.Voie;
import com.example.m6.dao.VoieDao;
import com.example.m6.service.facade.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoieServiceImpl implements VoieService {
    @Autowired
    private VoieDao voieDao;

    @Override
    public Voie findById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Voie> findAll() {
        return voieDao.findAll();
    }

    public Voie save(Voie voie) {
        Voie voi = null;

        if (findById(voie.getId()) == null) {
            voi = voieDao.save(voie);
        }
        return voi;

    }
}
