package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.FindOrderBoundary;
import com.br.fastBurguer.adapters.gateways.order.FindOrderGateway;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByPaymentStatusResponse;
import com.br.fastBurguer.adapters.presenters.order.OrderDTOMapper;
import com.br.fastBurguer.core.entities.Order;

public class FindOrder implements FindOrderBoundary {

    private final FindOrderGateway findOrderGateway;
    private final OrderDTOMapper orderDTOMapper;

    public FindOrder(FindOrderGateway findOrderGateway, OrderDTOMapper orderDTOMapper) {
        this.findOrderGateway = findOrderGateway;
        this.orderDTOMapper = orderDTOMapper;
    }

    @Override
    public FindOrderByPaymentStatusResponse findOrder(Long id) {
        Order orderFound = findOrderGateway.findOrder(id);

        if(orderFound == null){
            throw new RuntimeException("Order not found");
        }
        return orderDTOMapper.findOrderByPaymentStatusResponse(orderFound);
    }
}
