package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.order.FindOrderGateway;
import com.br.fastBurguer.core.entities.Order;

public class FindOrder {
    
    private final FindOrderGateway findOrderByPaymentStatusGateway;

    public FindOrder(FindOrderGateway findOrderByPaymentStatusGateway) {
        this.findOrderByPaymentStatusGateway = findOrderByPaymentStatusGateway;
    }

    public Order findOrder(Long id) {
        return findOrderByPaymentStatusGateway.findOrder(id);
    }
}
