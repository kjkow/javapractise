package com.packt.webstore.controller;

import com.packt.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kamil on 2017-09-04.
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/order/P1234/2")
    public String process(){
        orderService.processOrder("P1234", 2);
        return "redirect:/products";
    }
}
