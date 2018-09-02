package com.wangsaichao.cas.adaptors.generic;

import com.wangsaichao.cas.exception.CaptchaErrorException;
import com.wangsaichao.cas.exception.MyAccountNotFoundException;
import com.wangsaichao.cas.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.CredentialExpiredException;
import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;
import java.util.Map;

/**
 * @author: wangsaichao
 * @date: 2018/8/31
 * @description:
 */
public class RememberMeUsernamePasswordCaptchaAuthenticationHandler extends AbstractPreAndPostProcessingAuthenticationHandler {


    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RememberMeUsernamePasswordCaptchaAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

    @Override
    protected AuthenticationHandlerExecutionResult doAuthentication(Credential credential) throws GeneralSecurityException, PreventedException {
        RememberMeUsernamePasswordCaptchaCredential myCredential = (RememberMeUsernamePasswordCaptchaCredential) credential;
        String requestCaptcha = myCredential.getCaptcha();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object attribute = attributes.getRequest().getSession().getAttribute("captcha");

        String realCaptcha = attribute == null ? null : attribute.toString();

        if(StringUtils.isBlank(requestCaptcha) || !requestCaptcha.toUpperCase().equals(realCaptcha)){
            throw new CaptchaErrorException("验证码错误");
        }

        String username = myCredential.getUsername();
        Map<String, Object> user = userService.findByUserName(username);

        if(user == null){
            throw new MyAccountNotFoundException("用户不存在");
        }

        //可以在这里直接对用户名校验,或者调用 CredentialsMatcher 校验
        if (!user.get("password").equals(myCredential.getPassword())) {
            throw new CredentialExpiredException("用户名或密码错误！");
        }
        //这里将 密码对比 注销掉,否则 无法锁定  要将密码对比 交给 密码比较器 在这里可以添加自己的密码比较器等
        //if (!password.equals(user.getPassword())) {
        //    throw new IncorrectCredentialsException("用户名或密码错误！");
        //}
        if ("1".equals(user.get("state"))) {
            throw new AccountLockedException("账号已被锁定,请联系管理员！");
        }
        return createHandlerResult(credential, this.principalFactory.createPrincipal(username));
    }

    @Override
    public boolean supports(Credential credential) {
        return credential instanceof RememberMeUsernamePasswordCaptchaCredential;
    }
}
