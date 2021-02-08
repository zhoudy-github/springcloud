package com.spacetech.basedata;

import com.spacetech.basedata.annotation.ExcudeFeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableCircuitBreaker //激活Hystrix断路器
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.spacetech.basedata")
@EnableFeignClients
@EnableHystrix
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcudeFeignConfig.class)
})
public class BasedataApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasedataApplication.class, args);
    }

}
