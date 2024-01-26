package com.br.fastBurguer.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.adapters.boundary.CreateOrderBoundary;
import com.br.fastBurguer.adapters.boundary.FindAllOrdersBoundary;
import com.br.fastBurguer.adapters.boundary.FindOrderBoundary;
import com.br.fastBurguer.adapters.boundary.FindOrderByProductsBoundary;
import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.adapters.presenters.order.CreateOrderRequest;
import com.br.fastBurguer.adapters.presenters.order.FindAllOrdersResponse;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByPaymentStatusResponse;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByProductsRequest;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByProductsResponse;
import com.br.fastBurguer.adapters.presenters.order.OrderDTOMapper;

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

    private final CreateOrderBoundary createOrderBoundary;
    private final FindAllOrdersBoundary findAllOrdersBoundary;
    private final FindOrderBoundary findOrderBoundary;
    private final FindOrderByProductsBoundary findOrderByProductsBoundary;

    public OrderController(CreateOrderBoundary createOrderBoundary, OrderDTOMapper orderDTOMapper, FindAllOrdersBoundary findAllOrdersBoundary,
    FindOrderBoundary findOrderBoundary, FindOrderByProductsBoundary findOrderByProductsBoundary) {
        this.createOrderBoundary = createOrderBoundary;
        this.findAllOrdersBoundary = findAllOrdersBoundary;
        this.findOrderBoundary = findOrderBoundary;
        this.findOrderByProductsBoundary = findOrderByProductsBoundary;
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
                createOrderBoundary.createOrder(createOrderRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
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
        
        try {
                FindAllOrdersResponse orderToReturn = findAllOrdersBoundary.findAllOrders();
                return ResponseEntity.ok(orderToReturn);
                
        } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
        }

        
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
        
        try {
                FindOrderByPaymentStatusResponse orderToReturn = findOrderBoundary.findOrder(orderId);
                return ResponseEntity.ok(orderToReturn);
        } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
        }
         
    }

    @Operation(summary = "Find Order By Products List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders List Found", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content
            })
    })
    @GetMapping("/orderByProducts")
    public ResponseEntity<FindOrderByProductsResponse> getOrderByProducts(@RequestBody FindOrderByProductsRequest findOrderByProductsRequest) {
        
        try {
                FindOrderByProductsResponse orders = findOrderByProductsBoundary.findOrderByProducts(findOrderByProductsRequest);
                return ResponseEntity.ok(orders);
        } catch (Exception e) {
                return ResponseEntity.badRequest().build();
        }
        
    }
}
