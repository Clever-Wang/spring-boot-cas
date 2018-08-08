package com.wangsaichao.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import priv.wangsaichao.cas.client.configuration.EnableCasClient;

/**
 * @author: WangSaiChao
 * @date: 2018/8/2
 * @description: 启动类
 */
@SpringBootApplication
@EnableCasClient//开启cas
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
