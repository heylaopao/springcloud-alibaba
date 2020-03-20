package com.ruoyi.payment.service;

import com.ruoyi.api.entity.Payment;

public interface PaymentService {

    int insertSelective(Payment payment);

    Payment selectByPrimaryKey(Integer id);
}
