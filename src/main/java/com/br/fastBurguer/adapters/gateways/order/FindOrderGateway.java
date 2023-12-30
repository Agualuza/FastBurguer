package com.br.fastBurguer.adapters.gateways.order;

import com.br.fastBurguer.core.entities.Order;

public interface FindOrderGateway {
    
    public Order findOrder(Long id);
}
