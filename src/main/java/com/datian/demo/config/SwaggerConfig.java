package com.datian.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: huangyx
 * @Date: 2021/7/27 16:01
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了swagger的docket的bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            //是否启动swagger
            .enable(true)
            .select()
            //RequestHandlerSelectors:配置要扫描接口的方式
            //basePackage:指定要扫描的包
            //any:扫描全部
            //none：不扫描
            //withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
            //withMethodAnnotation：扫描方法上的注解
            .apis(RequestHandlerSelectors.basePackage("cn.hyx.bg.controller"))
            //paths:过滤什么路径
            // .paths(PathSelectors.ant("/com/sise/pass/**"))
            .build();
    }


    //配置swagger的信息
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("大田", "/", "413889948@qq.com");

        return new ApiInfo(
            "接口文档",
            "本项目为springBoot整合项目",
            "v1.0",
            "/",
            contact,
            "Apache 2.0",
            "http://www.apche.org/licenses/LICENSE-2.0",
            new ArrayList<>()
        );
    }

    /**
     * 初始化jedis
     * @return
     * @throws Exception
     */
    @Bean
    public JedisPool poolJedis() throws Exception {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲时间
        jedisPoolConfig.setMaxIdle(3000);
        jedisPoolConfig.setMaxWaitMillis(1000);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(true);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        // JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return new JedisPool();
    }


}



