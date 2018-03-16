# SpringCloud基础入门例子

## Eureka
spring cloud的服务注册与发现组件。<br>
![](https://github.com/kyo-qin/panda/blob/master/panda-resources/images/eureka01.jpg)

## Ribbon
客户端负载均衡工具，支持单独用，也可以和`eureka`结合起来用。<br>
>[Ribbon Git](https://github.com/Netflix/ribbon/wiki/Working-with-load-balancers)

## Feign
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
* 断路器状态，比如打开，关闭，半开；<br>
>spring-cloud-starter-hystrix为核心jar<br>
>spring-cloud-starter-hystrix-dashboard为监控jar<br>

***应用启动时需要加入Hystrix注解***
```java
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
}
```
***调用者方法加上HystrixCommand注解***
```java
    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000"),
            @HystrixProperty(name = "maxQueueSize", value = "10") })
    public NPConfigInfo findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, NPConfigInfo.class);
    }

    public NPConfigInfo findByIdFallback(Long id) {
        NPConfigInfo npConfigInfo = new NPConfigInfo();
        npConfigInfo.setConfigCode("fallBack");
        npConfigInfo.setId(-1);
        npConfigInfo.setConfigValue("fallback");
        return npConfigInfo;

    }
```
>[Hyetrix Command Properties](https://github.com/Netflix/Hystrix/wiki/Configuration#circuitBreaker.errorThresholdPercentage)<br>
>[Hystrix Git](https://github.com/Netflix/Hystrix)<br>

***Hystrix life cycle***
![](https://github.com/kyo-qin/panda/blob/master/panda-resources/images/hystrix-life-cycle.png)

***Hystrix配置注意***
```java
    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
        //return new feign.Contract.Default();
    }
```
>如果使用feign.Contract.Default()作为当前contract，则不支持使用@GetMapping，@RequestMapping这种SpringMVC使用的url请求注解，只能使用feign自带的注解@RequestLine。<br>

## Tubine
用于查看hystrix集群状态。<br>
***turbine的配置***
```yaml
turbine:
  aggregator:
    cluster-config: MICROSERVICE-CONSUMER-USER-RIBBON-HYSTRIX #集群名称
  app-config: microservice-consumer-user-ribbon-hystrix #app配置
```
turbine.stream路径：<br>
>http://localhost:8012/turbine.stream?cluster=MICROSERVICE-CONSUMER-USER-RIBBON-HYSTRIX
turbine.dashboard路径：<br>
>http://localhost:8012/hystrix
>将turbine.stream路径输入turbine的dashboard实现stream解读。

![](https://github.com/kyo-qin/panda/blob/master/panda-resources/images/turbine-dashboard.jpg)
***turbine监控多个应用的配置***
```java
turbine:
  aggregator:
    cluster-config: default
  app-config: microservice-consumer-user-ribbon-hystrix,microservice-consumer-user-feign-hystrix
  clusterNameExpression: "'default'"
```
![](https://github.com/kyo-qin/panda/blob/master/panda-resources/images/turbine-dashboard-n.jpg)
