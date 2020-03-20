package com.ruoyi.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ruoyi.payment.mapper")
public class Payment20001 {
    public static void main(String[] args) {
        SpringApplication.run(Payment20001.class, args);
    }

}
