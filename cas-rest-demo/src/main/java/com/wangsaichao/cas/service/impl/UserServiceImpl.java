package com.wangsaichao.cas.service.impl;

import com.wangsaichao.cas.dao.UserMapper;
import com.wangsaichao.cas.dao.entity.SysUser;
import com.wangsaichao.cas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wangsaichao
 * @date: 2018/8/1
 * @description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser selectUser(String username) {
        return userMapper.selectUser(username);
    }
}
