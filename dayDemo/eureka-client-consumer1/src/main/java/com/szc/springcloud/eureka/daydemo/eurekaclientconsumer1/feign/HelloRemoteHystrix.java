package com.szc.springcloud.eureka.daydemo.eurekaclientconsumer1.feign;

import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloRemoteHystrix
 * @Description: TODO
 * @Auther: sunzhichao
 * @Date: 2018/8/7 13:33
 * @Version: V1.0
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello guys ,i am consumer1 ,i have meeting a problem, please give me a little time ,i will check the config of myself." +
                "Thank you.";
    }
}
