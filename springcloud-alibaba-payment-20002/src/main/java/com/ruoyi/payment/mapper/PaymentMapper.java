package com.ruoyi.payment.mapper;

import com.ruoyi.api.entity.Payment;
import org.apache.ibatis.annotations.Select;

public interface PaymentMapper {

    int insertSelective(Payment payment);

    @Select("select * from tbl_payment where id = #{id}")
    Payment selectByPrimaryKey(Integer id);
}
