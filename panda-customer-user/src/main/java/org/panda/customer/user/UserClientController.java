package org.panda.customer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public NPConfigInfo findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:7900/simple/" + id, NPConfigInfo.class);
    }
}
