package com.br.fastBurguer.adapters.gateways.order;

import com.br.fastBurguer.core.entities.Order;

public interface CreateOrderGateway {
    
    public Order createOrder(Order order); 
}
