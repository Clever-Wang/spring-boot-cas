package com.wangsaichao.cas.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 等价于之前的SpringMVC.xml 
 * 可以在此配置拦截器,过滤器,监听器
 * 配置静态文件映射
 * @author xiyan
 *
 */
//@Configuration
public class SpringMVC extends WebMvcConfigurerAdapter {

//	@Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return converter;
//    }
//
//	@Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(responseBodyConverter());
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        //设置日期格式
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
//        objectMapper.setDateFormat(smt);
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        //设置中文编码格式
//        List<MediaType> list = new ArrayList<MediaType>();
//        list.add(MediaType.APPLICATION_JSON_UTF8);
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
//        return mappingJackson2HttpMessageConverter;
//    }
    
}