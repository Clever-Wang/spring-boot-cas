package com.wangsaichao.cas;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import priv.wangsaichao.cas.client.configuration.EnableCasClient;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: WangSaiChao
 * @date: 2018/8/2
 * @description: 启动类
 */
@SpringBootApplication
//@PropertySource(value={"classpath:config/path.properties"},ignoreResourceNotFound=true,encoding="utf-8")
//@ImportResource("classpath:spring/*.xml")
//@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
@EnableCasClient//开启cas
public class Application {

//	/**
//	 * cas服务端 url的前缀
//	 */
//	private static final String CAS_SERVER_URL_PREFIX = "https://server.cas.com:8443/cas";
//
//	/**
//	 * cas服务端 登录地址
//	 */
//	private static final String CAS_SERVER_LOGIN_URL = "https://server.cas.com:8443/cas/login";
//
//	/**
//	 * 本机服务的名称
//	 */
//	private static final String SERVER_NAME = "http://app2.cas.com:8082";
//
//
//	/**
//	 * 登录过滤器
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean filterSingleRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new SingleSignOutFilter());
//		// 设定匹配的路径
//		registration.addUrlPatterns("/*");
//		Map<String,String>  initParameters = new HashMap<String, String>();
//		initParameters.put("casServerUrlPrefix", CAS_SERVER_URL_PREFIX);
//		registration.setInitParameters(initParameters);
//		// 设定加载的顺序
//		registration.setOrder(1);
//		return registration;
//	}
//
//	/**
//	 * 过滤验证器
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean filterValidationRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
//		// 设定匹配的路径
//		registration.addUrlPatterns("/*");
//		Map<String,String> initParameters = new HashMap<String, String>();
//		initParameters.put("casServerUrlPrefix", CAS_SERVER_URL_PREFIX);
//		initParameters.put("serverName", SERVER_NAME);
//		initParameters.put("useSession", "true");
//		registration.setInitParameters(initParameters);
//		// 设定加载的顺序
//		registration.setOrder(1);
//		return registration;
//	}
//
//	/**
//	 * 授权过滤器
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean filterAuthenticationRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new AuthenticationFilter());
//		// 设定匹配的路径
//		registration.addUrlPatterns("/*");
//		Map<String,String>  initParameters = new HashMap<String, String>();
//		initParameters.put("casServerLoginUrl", CAS_SERVER_LOGIN_URL);
//		initParameters.put("serverName", SERVER_NAME);
//		initParameters.put("ignorePattern", "/js/*|/images/*|/view/*|/css/*");
//		initParameters.put("ignoreUrlPatternType", "com.wangsaichao.cas.config.SimpleUrlPatternMatcherStrategy");
//		registration.setInitParameters(initParameters);
//		// 设定加载的顺序
//		registration.setOrder(1);
//		return registration;
//	}
//
//	/**
//	 * wraper过滤器
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean filterWrapperRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new HttpServletRequestWrapperFilter());
//		// 设定匹配的路径
//		registration.addUrlPatterns("/*");
//		// 设定加载的顺序
//		registration.setOrder(1);
//		return registration;
//	}
//
//	/**
//	 * 添加监听器
//	 * @return
//	 */
//	@Bean
//	public ServletListenerRegistrationBean<EventListener> singleSignOutListenerRegistration(){
//		ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<EventListener>();
//		registrationBean.setListener(new SingleSignOutHttpSessionListener());
//		registrationBean.setOrder(1);
//		return registrationBean;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
