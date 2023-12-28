package com.br.fastBurguer.infra.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.adapters.presenters.order.CreateOrderRequest;
import com.br.fastBurguer.adapters.presenters.order.FindAllOrdersResponse;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByPaymentStatusResponse;
import com.br.fastBurguer.adapters.presenters.order.OrderDTOMapper;
import com.br.fastBurguer.application.useCases.CreateOrder;
import com.br.fastBurguer.application.useCases.FindAllOrders;
import com.br.fastBurguer.application.useCases.FindOrderByPaymentStatus;
import com.br.fastBurguer.core.entities.Order;

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

    private final CreateOrder createOrder;
    private final FindAllOrders findAllOrders;
    private final OrderDTOMapper orderDTOMapper;
    private final FindOrderByPaymentStatus findOrderByPaymentStatus;

    public OrderController(CreateOrder createOrder, OrderDTOMapper orderDTOMapper, FindAllOrders findAllOrders,
            FindOrderByPaymentStatus findOrderByPaymentStatus) {
        this.createOrder = createOrder;
        this.orderDTOMapper = orderDTOMapper;
        this.findAllOrders = findAllOrders;
        this.findOrderByPaymentStatus = findOrderByPaymentStatus;
    }

    @Operation(summary = "Create Order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order Created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CreateClientRequest.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content
            })
    })
    @PostMapping()
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {

        try {
            createOrder.createOrder(createOrderRequest.clientId(), orderDTOMapper.toDomain(createOrderRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        // criar queue
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders Found", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content
            })
    })
    @GetMapping()
    public ResponseEntity<FindAllOrdersResponse> listAllOrder() {
        List<Order> orders = findAllOrders.findAllOrders();
        FindAllOrdersResponse orderToReturn = orderDTOMapper.toListResponse(orders);

        return ResponseEntity.ok(orderToReturn);
    }

    @Operation(summary = "Find Order Status Payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders Found", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content
            })
    })
    @GetMapping("/paymentStatus")
    public ResponseEntity<FindOrderByPaymentStatusResponse> getOrderByStatus(@RequestParam("orderId") Long orderId) {
        Order order = findOrderByPaymentStatus.findOrderByPaymentStatus(orderId);
        return ResponseEntity.ok(orderDTOMapper.findOrderByPaymentStatusResponse(order));
    }
}
