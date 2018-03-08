package org.panda.provider.user;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class App {

    @Bean
    public MetricRegistry metrics() {
        return new MetricRegistry();
    }

    @Bean
    public Meter requestMeter(MetricRegistry metrics) {
        return metrics.meter("request");
    }

    // @Bean
    // public ConsoleReporter consoleReporter(MetricRegistry metrics) {
    // ConsoleReporter reporter =
    // ConsoleReporter.forRegistry(metrics).convertRatesTo(TimeUnit.SECONDS)
    // .convertDurationsTo(TimeUnit.MILLISECONDS).build();
    // reporter.start(1, TimeUnit.SECONDS);
    // return reporter;
    // }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
