package org.panda.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${profile}")
    private String profileValue;

    @GetMapping("/profile")
    public String getProfile() {
        return this.profileValue;
    }
}
