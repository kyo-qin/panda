# SpringCloud基础入门例子

## Eureka
* project `panda-discovery-eureka`
* project `panda-customer-user`
* project `panda-provider-user` <br>
spring cloud的服务注册与发现组件。<br>
![](https://github.com/kyo-qin/panda/blob/master/panda-resources/images/eureka01.jpg)

## Ribbon
* project `panda-customer-user-ribbon`
* project `panda-customer-user-ribbon-without-eureka` <br>
客户端负载均衡工具，支持单独用，也可以和`eureka`结合起来用。<br>
>[Ribbon Git](https://github.com/Netflix/ribbon/wiki/Working-with-load-balancers)

## Feign
* project `panda-customer-user-feign` <br>
声明式的rest客户端组件。<br>
使用feign的时候注意：<br>
1. 如果使用自定义配置类覆盖了原有配置，那么建议使用feign的注解，否则可能导致一些莫名其妙的问题，比如提示你方法要指定get post啦，或者提示你的参数太多啦（too many body parameters）。<br>
feign的注解比如下面这个：<br>
```java
    @RequestLine("GET /get_pay_result?app_id={app_id}&game_code={game_code}") // 不用这个注解的话，在使用覆盖配置类的情况下会报错
    // @RequestMapping(value = "/get_pay_result", method = RequestMethod.GET)
    public String getPayResult(@Param("app_id") final String appId,
            @Param("game_code") final String gameCode);<br>
```
2. 记得querystring要写在注解中，不然无法传递参数。比如：<br>
```java
    @RequestLine("GET /get_pay_result?app_id={app_id}&game_code={game_code}") //app_id和game_code需要指定。
```
3. feign不支持复杂对象做参数。<br>
>[Feign Git](https://github.com/OpenFeign/feign)

## Hystrix
断路器。Circuit Breaker<br>
* 监控失败率，例如失败率达到10%开启断路模式；
* 半开的时候做分流；
* 监控并恢复；
* 断路器状态，比如打开，关闭，半开；

>[Hystrix Git](https://github.com/Netflix/Hystrix)