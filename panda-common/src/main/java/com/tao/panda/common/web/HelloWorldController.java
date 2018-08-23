package com.tao.panda.common.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.panda.common.NetPayService;


@Controller
public class HelloWorldController {

    @Resource
    NetPayService netPayService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world！" + netPayService.getAllNPConfigInfos().size();
    }

}
