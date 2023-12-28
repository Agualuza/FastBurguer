package com.br.fastBurguer.adapters.gateways.order;

import com.br.fastBurguer.core.entities.Order;

public interface FindOrderByPaymentStatusGateway {
    
    public Order findOrderByPaymentStatus(Long id);
}
