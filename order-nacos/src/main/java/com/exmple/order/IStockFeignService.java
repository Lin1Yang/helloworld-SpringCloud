package com.exmple.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    name 是指定rest接口对应的服务名
    path 时指定的rest接口所在的StockController指定的@RequestMapping
 */
@FeignClient(name = "stock-service",path = "/stock")
public interface IStockFeignService {
    @RequestMapping("/reduct")
    public String reduct();
}
