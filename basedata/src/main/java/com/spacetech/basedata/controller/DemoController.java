package com.spacetech.basedata.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    //服务熔断
    @HystrixCommand(fallbackMethod = "demoFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "100"),   //请求次数
            //@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "100"),  //时间范围
            //@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸，此处为60%（上面配置意思是：10秒钟内，10次请求，失败率60%就不让用了）
            // 具体需要配置哪些参数，在 HystrixCommandProperties.java 类中
    })
    @GetMapping("/demo1")
    public String demo() {


        return "1";


    }

    @GetMapping("/demo2")
    public String demo2() {
        int i = 1 / 0;
        return "1";


    }

    public String demoFallback() {

        return "服务熔断了";

    }
}
