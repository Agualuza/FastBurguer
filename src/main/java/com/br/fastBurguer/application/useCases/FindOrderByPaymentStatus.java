package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.order.FindOrderByPaymentStatusGateway;
import com.br.fastBurguer.core.entities.Order;

public class FindOrderByPaymentStatus {
    
    private final FindOrderByPaymentStatusGateway findOrderByPaymentStatusGateway;

    public FindOrderByPaymentStatus(FindOrderByPaymentStatusGateway findOrderByPaymentStatusGateway) {
        this.findOrderByPaymentStatusGateway = findOrderByPaymentStatusGateway;
    }

    public Order findOrderByPaymentStatus(Long id) {
        return findOrderByPaymentStatusGateway.findOrderByPaymentStatus(id);
    }
}
