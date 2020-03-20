package com.ruoyi.payment.controller;

import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import com.ruoyi.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
@Api(tags = "支付中心")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    private static final String port = "2nd";

    @ApiOperation("根据id查找支付信息")
    @GetMapping("/{id}")
    public ResponseData findById(@PathVariable Integer id) {
        return ResponseData.success(paymentService.selectByPrimaryKey(id), port);
    }

    @ApiOperation("添加支付信息")
    @PostMapping
    public ResponseData save(@RequestBody Payment payment) {
        int result = paymentService.insertSelective(payment);
        return result > 0 ? ResponseData.success(payment, port) : ResponseData.failure(null, port);
    }

    /*服务降级*/
    @ApiOperation("服务降级测试")
    @GetMapping("/timeout")
    public ResponseData timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
            return ResponseData.success("超时测试", port);
        } catch (Exception e) {
            return ResponseData.failure(e.getMessage(), port);
        }
    }

    /*服务熔断*/
    @GetMapping("/circuitBreaker/{id}")
    @ApiOperation("服务熔断测试")
    public ResponseData circuitBreaker(@PathVariable Integer id) {
        if (id <= 0) {
            throw new RuntimeException(port + ", id can't be <= 0");
        }
        return ResponseData.success(paymentService.selectByPrimaryKey(id), port);
    }
}
