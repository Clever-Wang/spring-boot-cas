package com.wangsaichao.cas.service;

import com.wangsaichao.cas.dao.entity.SysUser;

/**
 * @author: WangSaiChao
 * @date: 2018/8/1
 * @description: 用户操作service层
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser selectUser(String username);
}
