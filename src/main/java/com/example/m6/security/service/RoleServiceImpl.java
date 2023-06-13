package com.example.m6.security.service;

import com.example.m6.security.bean.Role;
import com.example.m6.security.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role save(Role role) {
        Role loadedRole = roleDao.findByAuthority(role.getAuthority());
        if (loadedRole == null) {
            return roleDao.save(role);
        } else {
            return loadedRole;
        }
    }

    @Override
    public void save(Collection<Role> roles) {
        if (roles != null && !roles.isEmpty()) {
            for (Role role : roles) {
                Role foundedRole = findByAuthority(role.getAuthority());
                if (foundedRole != null) {
                    role.setId(foundedRole.getId());
                } else {
                    roleDao.save(role);
                }
            }
        }
    }

    @Override
    public Role findByAuthority(String authority) {
        return roleDao.findByAuthority(authority);
    }

    @Autowired
    private RoleDao roleDao;
}
