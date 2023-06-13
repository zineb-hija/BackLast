package com.example.m6.service.impl;

import com.example.m6.bean.Login;
import com.example.m6.dao.LoginDao;
import com.example.m6.service.facade.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Login findByIid(Long iid) {
        return loginDao.findByIid(iid);
    }

    @Override
    public int deleteByIid(Long iid) {
        return loginDao.deleteByIid(iid);
    }

    public boolean existsByIid(Long iid) {
        return loginDao.existsByIid(iid);
    }
    @Override

    public List<Login> findAll() {
        return loginDao.findAll();
    }

    public Login save(Login login) {
        Login log = null;

        if (findByIid(login.getIid()) == null) {
            log = loginDao.save(login);
        }
        return log;

    }
}
