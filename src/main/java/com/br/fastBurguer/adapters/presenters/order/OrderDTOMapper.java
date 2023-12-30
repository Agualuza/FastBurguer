package com.br.fastBurguer.adapters.presenters.order;

import java.util.ArrayList;
import java.util.List;

import com.br.fastBurguer.adapters.gateways.product.FindProductByIdGateway;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.core.entities.Product;

public class OrderDTOMapper {

    private final FindProductByIdGateway findProductByIdGateway;

    public OrderDTOMapper(FindProductByIdGateway findProductByIdGateway) {
        this.findProductByIdGateway = findProductByIdGateway;
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
            FindOrderResponse orderResponseToAdd = new FindOrderResponse(order.getId(), order.getClientId(), products, order.isPaymentApproved());
            responseOrders.add(orderResponseToAdd);
        }

        return new FindAllOrdersResponse(responseOrders);
    }

    public FindOrderByPaymentStatusResponse findOrderByPaymentStatusResponse(Order order) {
        return new FindOrderByPaymentStatusResponse(order.getId(), order.isPaymentApproved());
    }
}
