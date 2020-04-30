package com.cssth.esco.dao;

import com.cssth.esco.entities.Payment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface PaymentDao {

    @Insert("insert into payment(serial) values(#{payment.serial})")
    @Options(keyProperty = "user.id", useGeneratedKeys = true)
    public int create(Payment payment);

    @Select("select * from payment where id=#{id}")
    @Results(id = "payment", value = {@Result(property = "id", column = "id"),
            @Result(property = "serial",column = "serial",javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public Payment getPaymentById(@Param("id") Long id);
}
