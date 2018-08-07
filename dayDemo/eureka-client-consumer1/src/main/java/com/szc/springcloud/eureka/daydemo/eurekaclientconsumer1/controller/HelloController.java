package com.szc.springcloud.eureka.daydemo.eurekaclientconsumer1.controller;

import com.szc.springcloud.eureka.daydemo.eurekaclientconsumer1.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Auther: sunzhichao
 * @Date: 2018/8/7 11:40
 * @Version: V1.0
 */
@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping("/helloConsumer")
    public String helloConsumer1 (@RequestParam(value = "name") String name) {
        return helloRemote.hello(name+"consumer1");
    }
}
