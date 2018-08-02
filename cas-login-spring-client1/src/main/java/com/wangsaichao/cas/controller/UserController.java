package com.wangsaichao.cas.controller;

import com.wangsaichao.cas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangsaichao
 * @date: 2018/8/1
 * @description: 用户相关操作controller
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("insert")
    public String insert(String username){

        userService.insert(username);
        return "result";
    }

}
