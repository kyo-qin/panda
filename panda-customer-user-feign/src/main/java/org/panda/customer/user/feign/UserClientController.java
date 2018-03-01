package org.panda.customer.user.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientController {

    @Autowired
    private NPConfigInfoFeignClient npConfigInfoFeignClient;

    @Autowired
    private TestFeignClient testFeignClient;

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    @GetMapping("/movie/{id}")
    public NPConfigInfo findById(@PathVariable Integer id) {
        return npConfigInfoFeignClient.findById(id);
    }

    @RequestMapping(value = "/movie/get_pay_result", method = RequestMethod.GET)
    public String getPayResult() {
        return testFeignClient.getPayResult("100005", "110256017155");
        // return testFeignClient.getPayResult("100005", "110256017155",
        // "A151978928384556", "20180228114151",
        // "4fbc91ad6f88228b076646816a47f0da");
    }

}
