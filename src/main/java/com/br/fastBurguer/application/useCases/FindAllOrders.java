package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.boundary.FindAllOrdersBoundary;
import com.br.fastBurguer.adapters.gateways.order.FindAllOrdersGateway;
import com.br.fastBurguer.adapters.presenters.order.FindAllOrdersResponse;
import com.br.fastBurguer.adapters.presenters.order.OrderDTOMapper;
import com.br.fastBurguer.core.entities.Order;

public class FindAllOrders implements FindAllOrdersBoundary {

    private final FindAllOrdersGateway findAllOrdersGateway;
    private final OrderDTOMapper orderDTOMapper;

    public FindAllOrders(FindAllOrdersGateway findAllOrdersGateway, OrderDTOMapper orderDTOMapper) {
        this.findAllOrdersGateway = findAllOrdersGateway;
        this.orderDTOMapper = orderDTOMapper;
    }

    @Override
    public FindAllOrdersResponse findAllOrders() {
        List<Order> listFound = findAllOrdersGateway.findAllOrders();
        return orderDTOMapper.toListResponse(listFound);
    }
}
