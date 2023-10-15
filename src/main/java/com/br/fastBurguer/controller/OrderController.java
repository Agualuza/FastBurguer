package com.br.fastBurguer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.domain.order.Order;
import com.br.fastBurguer.domain.order.dto.OrderDto;
import com.br.fastBurguer.domain.order.dto.OrderResponseControllerDto;
import com.br.fastBurguer.domain.products.Product;
import com.br.fastBurguer.services.OrderService;
import com.br.fastBurguer.services.ProductService;
import com.br.fastBurguer.services.QueueService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @Autowired
    QueueService queueService;

    @Autowired
    ProductService productService;

    @PostMapping() 
    public void createOrder(@RequestBody OrderDto order) {
        Order orderEntity = orderService.createOrder(order);
        queueService.createQueue(orderEntity);
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponseControllerDto>> listAllOrder() {
        List<Order> orders = orderService.listAllOrders();
        List<OrderResponseControllerDto> orderToReturn = new ArrayList<>();
        

        for (Order order : orders) {
            List<String> products = new ArrayList<>();
            System.out.println(order.getProdutcsIds());
            for (Long orderArray : order.getProdutcsIds()) {
                Optional<Product> product = productService.findProductById(orderArray);
                products.add(product.get().getName());
            }
            
            orderToReturn.add(new OrderResponseControllerDto(order.getClient().getId(), products));
        }
        
        return ResponseEntity.ok(orderToReturn);
    }
}
