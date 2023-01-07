package com.datian.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import redis.clients.jedis.JedisPool;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private JedisPool jedisPool;
    @Test
    void contextLoads() {

//        jedisPool.getResource().set("11","22");
//        String s = jedisPool.getResource().get("11");
//        System.out.println(s);
    }

}
