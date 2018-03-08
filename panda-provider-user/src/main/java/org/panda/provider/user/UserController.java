package org.panda.provider.user;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.Meter;

@RestController
public class UserController {

    @Resource
    NetPayService netPayService;

    @Autowired
    Meter requestMeter;

    @GetMapping("/simple/{id}")
    public NPConfigInfo findById(@PathVariable Integer id) {
        requestMeter.mark();
        return netPayService.getAllNPConfigInfos().get(id);
    }

}
