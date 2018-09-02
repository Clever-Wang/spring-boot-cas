package com.wangsaichao.cas.exception;

import javax.security.auth.login.AccountException;

/**
 * @author: wangsaichao
 * @date: 2018/8/31
 * @description: 验证码错误异常类
 */
public class CaptchaErrorException extends AccountException {

    public CaptchaErrorException() {
        super();
    }

    public CaptchaErrorException(String msg) {
        super(msg);
    }
}
