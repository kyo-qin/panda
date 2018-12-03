package org.panda.consul.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulClientController {

    @GetMapping("/uc/info")
    public String getInfo(HttpServletRequest request, HttpServletResponse response) {
        return "This is consul client one!";
    }
}
