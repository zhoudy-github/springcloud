package com.spacetech.user.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//熔断方法
@Service
public class BasedataFeginFailBackImpl implements BasedataApi {


    @Override
    public String demo() {
        return "{\"id\":-1,\"name\":\"熔断用户\",\"msg\":\"请求异常，返回熔断用户！\"}";
    }

    @Override
    public String demo2() {
        return "{\"id\":-1,\"name\":\"熔断用户\",\"msg\":\"请求异常，返回熔断用户！\"}";
    }


}
