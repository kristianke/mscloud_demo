package com.cssth.esoc.controler;

import com.cssth.esoc.entities.CommonResult;
import com.cssth.esoc.entities.Payment;
import com.cssth.esoc.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentControler {

    @Resource
    PaymentService service;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/discovery")
    public DiscoveryClient getDiscoveryInfo(){
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("-------Service:" + s);
            List<ServiceInstance> instances = discoveryClient.getInstances(s);
            for (ServiceInstance instance : instances) {
                log.info("********Serviceid:" + instance.getServiceId());
                log.info("********instanceid:" + instance.getInstanceId());
                log.info("********host:" + instance.getHost());
                log.info("********port:" + instance.getPort());
                log.info("********uri:" + instance.getUri());
            }
        }
        return discoveryClient;
    }

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
            return new CommonResult(200,"插入成功,port:" + port, payment);
        }else
            return new CommonResult(333,"插入失败");
    }
}
