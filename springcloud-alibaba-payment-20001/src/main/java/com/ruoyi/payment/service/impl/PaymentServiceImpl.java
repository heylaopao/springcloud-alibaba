package com.ruoyi.payment.service.impl;

import com.ruoyi.api.entity.Payment;
import com.ruoyi.payment.mapper.PaymentMapper;
import com.ruoyi.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int insertSelective(Payment payment) {
        return paymentMapper.insertSelective(payment);
    }

    @Override
    public Payment selectByPrimaryKey(Integer id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
