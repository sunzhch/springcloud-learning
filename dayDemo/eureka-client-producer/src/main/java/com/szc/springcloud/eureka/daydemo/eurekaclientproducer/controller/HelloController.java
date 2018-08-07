package com.szc.springcloud.eureka.daydemo.eurekaclientproducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: HelloController 注册中心服务提供者
 * @Auther: sunzhichao
 * @Date: 2018/8/2 16:07
 * @Version: V1.0
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello (@RequestParam(value = "name") String name) {
        return "hello " + name + " ,welcome to eureka-client-producer HelloController, i am at "+port;
    }
}
