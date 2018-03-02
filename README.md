SpringCloud基础入门例子
===
# eureka

# ribbon
客户端负载均衡工具，支持单独用，也可以和eureka结合起来用。

# feign
声明式的rest客户端组件。
使用feign的时候注意：
1. 如果使用自定义配置类覆盖了原有配置，那么建议使用feign的注解，否则可能导致一些莫名其妙的问题，比如提示你方法要指定get post啦，或者提示你的参数太多啦（too many body parameters）。feign的注解比如下面这个：
@RequestLine("GET /get_pay_result?app_id={app_id}&game_code={game_code}") // 不用这个注解的话，在使用覆盖配置类的情况下会报错
    // @RequestMapping(value = "/get_pay_result", method = RequestMethod.GET)
    public String getPayResult(@Param("app_id") final String appId,
            @Param("game_code") final String gameCode);
2. 记得querystring要写在注解中，不然无法传递参数，比如@RequestLine("GET /get_pay_result?app_id={app_id}&game_code={game_code}")中的app_id和game_code