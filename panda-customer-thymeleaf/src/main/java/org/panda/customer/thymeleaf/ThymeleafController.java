package org.panda.customer.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/")
    public String index() {
        return "/index";
    }
    
}
