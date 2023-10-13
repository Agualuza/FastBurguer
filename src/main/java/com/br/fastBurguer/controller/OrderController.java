package com.br.fastBurguer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.domain.order.Order;
import com.br.fastBurguer.domain.order.dto.OrderDto;
import com.br.fastBurguer.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @PostMapping() 
    public void createOrder(@RequestBody OrderDto order) {
        System.out.println(order);
        orderService.createOrder(order);
    }

    @GetMapping()
    public List<Order> listAllOrder() {
        return orderService.listAllOrders();
    }
}
