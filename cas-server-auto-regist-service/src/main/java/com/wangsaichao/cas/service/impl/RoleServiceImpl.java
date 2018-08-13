package com.wangsaichao.cas.service.impl;

import com.wangsaichao.cas.dao.RoleDao;
import com.wangsaichao.cas.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author: wangsaichao
 * @date: 2018/7/19
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public String findRolesByUserId(String uid) {
        return roleDao.findRolesByUserId(uid);
    }

    @Override
    public Set<String> findAllRoles() {
        return roleDao.findAllRoles();
    }
}
