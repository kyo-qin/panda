package org.panda.customer.thymeleaf;

import org.panda.common.spring.boot.starter.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    @Autowired
    private CommonService commonService;

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @ResponseBody
    @RequestMapping("/version")
    public String getVersion() {
        return commonService.getVersion();
    }

}
