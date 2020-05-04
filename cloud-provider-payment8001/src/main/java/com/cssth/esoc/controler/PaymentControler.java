package com.cssth.esoc.controler;

import com.cssth.esoc.entities.CommonResult;
import com.cssth.esoc.entities.Payment;
import com.cssth.esoc.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentControler {

    @Resource
    PaymentService service;
    @Value("${server.port}")
    private String port;
    @RequestMapping(value = "/payment/getById/{id}", method = RequestMethod.GET)
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        if (payment == null){
            return new CommonResult(444,"没有对应记录，id:" + id);
        }else{
            return new CommonResult(200,"查询成功,port:" + port,payment);
        }
    }

    @PostMapping(value = "/payment/add")
    public CommonResult addPayment(@RequestBody Payment payment){
        int result = service.create(payment);
        log.info("******插入结果******" + result);
        if (result > 0){
            return new CommonResult(200,"插入成功,port:"+port, payment);
        }else
            return new CommonResult(333,"插入失败");
    }
}
