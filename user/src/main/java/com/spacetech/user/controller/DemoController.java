package com.spacetech.user.controller;

import com.spacetech.user.feign.BasedataApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * 注意是 org.springframework.cloud.client.discovery.DiscoveryClient;不是
     */
	/*@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/service-instance/{applicationName}")
	public List<ServiceInstance> getServiceInstance(@PathVariable String applicationName) {
		
		return client.getInstances(applicationName);
		
		
	}*/

    @Autowired
    private BasedataApi basedataApi;

    @GetMapping("/demo1")
    public int demo1(@RequestParam("id") int id) {

        return id;


    }

    @GetMapping("/demo2")
    public String demo2(@RequestParam("id") int id) {

        return basedataApi.demo();


    }

    @GetMapping("/demo3")
    public String demo3(@RequestParam("id") int id) {

        return basedataApi.demo2();


    }
}
