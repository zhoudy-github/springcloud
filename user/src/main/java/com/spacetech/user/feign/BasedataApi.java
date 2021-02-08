package com.spacetech.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "basedata", fallback = BasedataFeginFailBackImpl.class)
public interface BasedataApi {

    @GetMapping("/demo/demo1")
    String demo();

    @GetMapping("/demo/demo2")
    String demo2();
}
