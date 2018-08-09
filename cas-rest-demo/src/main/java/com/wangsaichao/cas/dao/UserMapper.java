package com.wangsaichao.cas.dao;

import com.wangsaichao.cas.dao.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author: WangSaiChao
 * @date: 2018/8/1
 * @description: 用户操作 dao层
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser selectUser(@Param("username") String username);
}
