package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.boundary.FindOrderByProductsBoundary;
import com.br.fastBurguer.adapters.gateways.order.FindOrderByProductsGateway;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByProductsRequest;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByProductsResponse;
import com.br.fastBurguer.adapters.presenters.order.OrderDTOMapper;
import com.br.fastBurguer.core.entities.Order;

public class FindOrderByProducts implements FindOrderByProductsBoundary {

    private final FindOrderByProductsGateway findOrderByProductsGateway;
    private final OrderDTOMapper orderDTOMapper;

    public FindOrderByProducts(FindOrderByProductsGateway findOrderByProductsGateway, OrderDTOMapper orderDTOMapper) {
        this.findOrderByProductsGateway = findOrderByProductsGateway;
        this.orderDTOMapper = orderDTOMapper;
    }

    @Override
    public FindOrderByProductsResponse findOrderByProducts(FindOrderByProductsRequest findOrderByProductsRequest) {
        List<Order> ordersFound = findOrderByProductsGateway.findOrderByProducts(findOrderByProductsRequest.products());

        return orderDTOMapper.findOrderByProductsResponse(ordersFound);
    }
}
