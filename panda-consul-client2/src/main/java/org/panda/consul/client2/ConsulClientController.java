package org.panda.consul.client2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/uc/info")
    public String getInfo(HttpServletRequest request, HttpServletResponse response) {
        return "This is consul client two!";
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        String result = restTemplate.getForObject("http://microservice-provider-consul-client/uc/info", String.class);
        ServiceInstance instance = this.loadBalancerClient.choose("microservice-provider-consul-client");
        return result + ",HOST:" + instance.getHost() + ",PORT:" + instance.getPort();
    }
}
