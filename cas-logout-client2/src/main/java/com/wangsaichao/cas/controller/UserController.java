package com.wangsaichao.cas.controller;

import com.wangsaichao.cas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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


    /**
     * 跳转到默认页面
     * @param session
     * @return
     */
    @RequestMapping("/logout1")
    public String loginOut(HttpSession session){
        session.invalidate();
        //这个是直接退出，走的是默认退出方式
        return "redirect:https://server.cas.com:8443/cas/logout";
    }

    /**
     * 跳转到指定页面
     * @param session
     * @return
     */
    @RequestMapping("/logout2")
    public String loginOut2(HttpSession session){
        session.invalidate();
        //退出登录后，跳转到退成成功的页面，不走默认页面
        return "redirect:https://server.cas.com:8443/cas/logout?service=http://app2.cas.com:8082";
    }

}
