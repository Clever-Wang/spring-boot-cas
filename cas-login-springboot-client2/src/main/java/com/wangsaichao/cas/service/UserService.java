package com.wangsaichao.cas.service;

/**
 * @author: WangSaiChao
 * @date: 2018/8/1
 * @description: 用户操作service层
 */
public interface UserService {

    /**
     * 创建用户
     * @param username
     * @return
     */
    void insert(String username);
}
