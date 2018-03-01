package org.panda.customer.user.feign;

import org.panda.customer.user.config.TestFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "egame.open.pay", url = "http://202.102.39.8/api/v1/charge/epay/sdk/41x", configuration = TestFeignConfiguration.class)
public interface TestFeignClient {

    @RequestLine("GET /get_pay_result?app_id={app_id}&game_code={game_code}") // 不用这个注解的话，在使用覆盖配置类的情况下会报错
    // @RequestMapping(value = "/get_pay_result", method = RequestMethod.GET)
    public String getPayResult(@Param("app_id") final String appId,
            @Param("game_code") final String gameCode);
}
