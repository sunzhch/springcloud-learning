package com.szc.springcloud.eureka.daydemo.eurekaclientconsumer1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: HelloRemote
 * @Description: feign 方法
 * @Auther: sunzhichao
 * @Date: 2018/8/7 11:37
 * @Version: V1.0
 */
@FeignClient(value = "eureka-client-producer",fallback = HelloRemoteHystrix.class)
@Service
public interface HelloRemote {
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name);
}
