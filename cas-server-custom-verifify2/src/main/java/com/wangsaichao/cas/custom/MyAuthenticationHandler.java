package com.wangsaichao.cas.custom;

import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;

import javax.security.auth.login.AccountNotFoundException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: wangsaichao
 * @date: 2018/7/21
 * @description: 自定义验证器
 */
public class MyAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler{

    public MyAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

    @Override
    protected AuthenticationHandlerExecutionResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential, String originalPassword) throws GeneralSecurityException, PreventedException {

        if("admin".equals(credential.getUsername())){
            return createHandlerResult(credential,
                    this.principalFactory.createPrincipal(credential.getUsername()),
                    new ArrayList<>(0));
        }else{
            throw new AccountNotFoundException("必须是admin用户才允许通过");
        }
    }
}
