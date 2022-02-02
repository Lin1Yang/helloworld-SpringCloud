package com.exmple.order.controller;

import com.exmple.order.IStockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    /*RestTemplate restTemplate;*/
    IStockFeignService stockFeignService;

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功！");
        //String msg = restTemplate.getForObject("http://stock-service/stock/reduct",String.class);
        String msg = stockFeignService.reduct();
        return "Hello World"+msg;
    }
}
