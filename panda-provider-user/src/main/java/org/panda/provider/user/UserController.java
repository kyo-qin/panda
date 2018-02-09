package org.panda.provider.user;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    NetPayService netPayService;

    @GetMapping("/simple/{id}")
    public NPConfigInfo findById(@PathVariable Integer id) {
        return netPayService.getAllNPConfigInfos().get(id);
    }

}
