package org.panda.customer.user.feign.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientController {

    @Autowired
    private NPConfigInfoFeignClient npConfigInfoFeignClient;

    //@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    @GetMapping("/movie/{id}")
    public NPConfigInfo findById(@PathVariable Integer id) {
        return npConfigInfoFeignClient.findById(id);
    }

}
