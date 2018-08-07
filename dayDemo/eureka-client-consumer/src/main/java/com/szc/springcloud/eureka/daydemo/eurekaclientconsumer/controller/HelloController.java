package com.szc.springcloud.eureka.daydemo.eurekaclientconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Auther: sunzhichao
 * @Date: 2018/8/2 16:42
 * @Version: V1.0
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/helloConsumer")
    public String helloConsumer(@RequestParam(value = "name") String name) {
        return helloService.hiService(name);
    }
}
