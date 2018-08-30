package com.wangsaichao.cas.adaptors.generic;

import com.wangsaichao.cas.service.RoleService;
import com.wangsaichao.cas.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apereo.cas.authentication.*;
import org.apereo.cas.authentication.exceptions.AccountDisabledException;
import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.CredentialExpiredException;
import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Set;

/**
 * @author: wangsaichao
 * @date: 2018/7/17
 * @description:
 */
public class ShiroAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    private static final Logger logger = LoggerFactory.getLogger(ShiroAuthenticationHandler.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public ShiroAuthenticationHandler(String name,ServicesManager servicesManager,PrincipalFactory principalFactory,Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

    @Override
    protected AuthenticationHandlerExecutionResult authenticateUsernamePasswordInternal(UsernamePasswordCredential transformedCredential,String originalPassword) throws GeneralSecurityException {

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(transformedCredential.getUsername(),transformedCredential.getPassword());

            if (transformedCredential instanceof RememberMeUsernamePasswordCredential) {
                token.setRememberMe(RememberMeUsernamePasswordCredential.class.cast(transformedCredential).isRememberMe());
            }

            Subject currentUser = getCurrentExecutingSubject();
            currentUser.login(token);

            checkSubjectRolesAndPermissions(currentUser);

            return createAuthenticatedSubjectResult(transformedCredential, currentUser);
        } catch (final UnknownAccountException uae) {
            throw new AccountNotFoundException(uae.getMessage());
        } catch (final IncorrectCredentialsException ice) {
            throw new FailedLoginException(ice.getMessage());
        } catch (final LockedAccountException | ExcessiveAttemptsException lae) {
            throw new AccountLockedException(lae.getMessage());
        } catch (final ExpiredCredentialsException eae) {
            throw new CredentialExpiredException(eae.getMessage());
        } catch (final DisabledAccountException eae) {
            throw new AccountDisabledException(eae.getMessage());
        } catch (final AuthenticationException e) {
            throw new FailedLoginException(e.getMessage());
        }
    }

    /**
     * Check subject roles and permissions.
     * 这只是举个简单的例子 进行对比,可以自己写 自己对应的逻辑
     *
     * @param currentUser the current user
     * @throws FailedLoginException the failed login exception in case roles or permissions are absent
     */
    protected void checkSubjectRolesAndPermissions(final Subject currentUser) throws FailedLoginException {

        //查询用户id， 也可以在登录成功之后,将id 放到session中,从session中获取,这里直接查库
        Map<String, Object> user = userService.findByUserName(String.valueOf(currentUser.getPrincipal()));
        //获取所有的用户角色
        Set<String> allRoles = roleService.findAllRoles();
        //根据id获取用户的角色,这里一个用户只对应一个角色
        String userRole = roleService.findRolesByUserId(String.valueOf(user.get("uid")));
        //判断如果有角色,就登陆成功
        for (String role : allRoles){
            if (role.equals(userRole)) {
                return;
            }
        }
        //否则抛出异常,也可以自定义异常,返回不同的提示
        throw new FailedLoginException();
    }

    /**
     * Create authenticated subject result.
     *
     * @param credential  the credential
     * @param currentUser the current user
     * @return the handler result
     */
    protected AuthenticationHandlerExecutionResult createAuthenticatedSubjectResult(final Credential credential, final Subject currentUser) {
        final String username = currentUser.getPrincipal().toString();
        return createHandlerResult(credential, this.principalFactory.createPrincipal(username));
    }

    /**
     * Gets current executing subject.
     *
     * @return the current executing subject
     */
    protected Subject getCurrentExecutingSubject() {
        return SecurityUtils.getSubject();
    }
}
