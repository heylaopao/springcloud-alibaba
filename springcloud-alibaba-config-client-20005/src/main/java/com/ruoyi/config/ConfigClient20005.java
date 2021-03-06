package com.ruoyi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClient20005 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient20005.class, args);
    }

    @Value("${env}")
    private String env;

    @GetMapping
    public String index() {
        return env;
    }

}
