package com.tao.panda.common.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulHelloWorldController {

    @RequestMapping("hello_rest")
    public String hello() {
        return "restful hello world！";
    }

}
