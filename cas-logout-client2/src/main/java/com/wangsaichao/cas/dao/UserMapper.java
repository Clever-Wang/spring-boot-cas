package com.wangsaichao.cas.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: WangSaiChao
 * @date: 2018/8/1
 * @description: 用户操作 dao层
 */
@Mapper
public interface UserMapper {

    /**
     * 创建用户
     * @param username
     * @param password
     * @return
     */
    void insert(@Param("username") String username, @Param("password") String password);
}
