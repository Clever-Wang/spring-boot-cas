package com.wangsaichao.cas.service;

import java.util.Map;

/**
 * @author: wangsaichao
 * @date: 2018/7/19
 * @description:
 */
public interface UserService {

    Map<String,Object> findByUserName(String userName);
}
