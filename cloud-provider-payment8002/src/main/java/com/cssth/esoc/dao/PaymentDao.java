package com.cssth.esoc.dao;

import com.cssth.esoc.entities.Payment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface PaymentDao {

    @Insert("insert into payment(serial) values(#{serial})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    public int create(Payment payment);

    @Select("select * from payment where id=#{id}")
    @Results(id = "payment", value = {@Result(property = "id", column = "id"),
            @Result(property = "serial",column = "serial",javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public Payment getPaymentById(@Param("id") Long id);
}
