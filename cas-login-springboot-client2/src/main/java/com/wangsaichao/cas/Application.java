package com.wangsaichao.cas;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

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

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
