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

import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.domain.order.Order;
import com.br.fastBurguer.domain.order.dto.OrderDto;
import com.br.fastBurguer.domain.order.dto.OrderResponseControllerDto;
import com.br.fastBurguer.domain.products.Product;
import com.br.fastBurguer.services.OrderService;
import com.br.fastBurguer.services.ProductService;
import com.br.fastBurguer.services.QueueService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/order")
@Tag(name = "Orders", description = "Order create and search")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @Autowired
    QueueService queueService;

    @Autowired
    ProductService productService;

    @Operation(summary = "Create Order")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Order Created",
            content = {
                @Content(mediaType = "application/json",
                schema = @Schema(implementation = ClientDto.class))
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
    @PostMapping() 
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto order) {
        Order orderEntity = orderService.createOrder(order);
        queueService.createQueue(orderEntity);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search all orders")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Orders Found",
            content = {
                @Content
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
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
