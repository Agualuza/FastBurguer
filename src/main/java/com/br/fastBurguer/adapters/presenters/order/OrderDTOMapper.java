package com.br.fastBurguer.adapters.presenters.order;

import java.text.SimpleDateFormat;
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

        List<FindOrderResponse> responseOrdersReady = new ArrayList<>();
        List<FindOrderResponse> responseOrdersDoing = new ArrayList<>();
        List<FindOrderResponse> responseOrdersReceive = new ArrayList<>();

        for (Order order : orders) {
            List<Product> products = new ArrayList<>();
            for (Long id : order.getProducts()) {
                Product product = findProductByIdGateway.findProductById(id);
                products.add(product);
            }
            Queue queue = findQueueByOrderId.findQueueByOrderId(order.getId());

            if (!queue.getStatus().equalsIgnoreCase("finalizado")) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                FindOrderResponse orderResponseToAdd = new FindOrderResponse(order.getId(), order.getClientId(),
                        products,
                        queue.getStatus(), order.isPaymentApproved(), dateFormat.format(order.getCreatedAt()));

                switch (queue.getStatus()) {
                    case "Pronto":
                        responseOrdersReady.add(orderResponseToAdd);
                        break;
                    case "Em preparação":
                        responseOrdersDoing.add(orderResponseToAdd);
                        break;
                    case "Recebido":
                        responseOrdersReceive.add(orderResponseToAdd);
                        break;
                    default:
                        break;

                }
            }
        }

        responseOrders.addAll(responseOrdersReady);
        responseOrders.addAll(responseOrdersDoing);
        responseOrders.addAll(responseOrdersReceive);

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
