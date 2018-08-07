package com.szc.springcloud.eureka.daydemo.eurekaclientconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: HelloService
 * @Description: TODO
 * @Auther: sunzhichao
 * @Date: 2018/8/7 14:23
 * @Version: V1.0
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-client-producer/hello?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",i am consumer, i met sth error,please wait me for a few minutes, i will check it myself!";
    }

}