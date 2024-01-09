package com.br.fastBurguer.adapters.presenters.order;

import java.util.ArrayList;
import java.util.List;

import com.br.fastBurguer.adapters.gateways.product.FindProductByIdGateway;
import com.br.fastBurguer.application.useCases.FindQueueByOrderId;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.core.entities.Product;
import com.br.fastBurguer.core.entities.Queue;

public class OrderDTOMapper {

    private final FindProductByIdGateway findProductByIdGateway;
    private final FindQueueByOrderId findQueueByOrderId;

    public OrderDTOMapper(FindProductByIdGateway findProductByIdGateway, FindQueueByOrderId findQueueByOrderId) {
        this.findProductByIdGateway = findProductByIdGateway;
        this.findQueueByOrderId = findQueueByOrderId;
    }

    public List<Long> toDomain(CreateOrderRequest createOrderRequest) {
        return createOrderRequest.products();
    }

    public FindAllOrdersResponse toListResponse(List<Order> orders) {

        List<FindOrderResponse> responseOrders = new ArrayList<>();

        for (Order order : orders) {
            List<Product> products = new ArrayList<>();
            for (Long id : order.getProducts()) {
                Product product = findProductByIdGateway.findProductById(id);
                products.add(product);
            }
            Queue queue = findQueueByOrderId.findQueueByOrderId(order.getId());

            if (!queue.getStatus().equalsIgnoreCase("finalizado")) {
                FindOrderResponse orderResponseToAdd = new FindOrderResponse(order.getId(), order.getClientId(),
                        products,
                        queue.getStatus(), order.isPaymentApproved());
                responseOrders.add(orderResponseToAdd);
            }
        }

        return new FindAllOrdersResponse(responseOrders);
    }

    public FindOrderByPaymentStatusResponse findOrderByPaymentStatusResponse(Order order) {
        return new FindOrderByPaymentStatusResponse(order.getId(), order.isPaymentApproved());
    }

    public FindOrderByProductsResponse findOrderByProductsResponse(List<Order> orders) {
        List<Long> responseIds = new ArrayList<>();

        for (Order order : orders) {
            responseIds.add(order.getId());
        }

        return new FindOrderByProductsResponse(responseIds);
    }
}
