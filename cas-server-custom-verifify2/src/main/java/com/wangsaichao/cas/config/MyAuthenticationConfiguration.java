package com.wangsaichao.cas.config;

import com.wangsaichao.cas.custom.MyAuthenticationHandler;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlan;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationHandler;
import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.services.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangsaichao
 * @date: 2018/7/21
 * @description: 注册验证器
 */
@Configuration("myAuthenticationConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class MyAuthenticationConfiguration implements AuthenticationEventExecutionPlanConfigurer {


    @Autowired
    private CasConfigurationProperties casProperties;

    @Autowired
    @Qualifier("servicesManager")
    private ServicesManager servicesManager;

    /**
     * 将自定义验证器注册为Bean
     * @return
     */
    @Bean
    public AuthenticationHandler myAuthenticationHandler() {
        MyAuthenticationHandler handler = new MyAuthenticationHandler(MyAuthenticationHandler.class.getSimpleName(), servicesManager, new DefaultPrincipalFactory(), 1);
        return handler;
    }

    /**
     * 注册验证器
     * @param plan
     */
    @Override
    public void configureAuthenticationExecutionPlan(AuthenticationEventExecutionPlan plan) {
        plan.registerAuthenticationHandler(myAuthenticationHandler());
    }
}
