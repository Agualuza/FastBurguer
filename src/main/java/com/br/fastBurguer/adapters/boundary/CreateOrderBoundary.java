package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.order.CreateOrderRequest;

public interface CreateOrderBoundary {
    
    public void createOrder(CreateOrderRequest createOrderRequest);
}
