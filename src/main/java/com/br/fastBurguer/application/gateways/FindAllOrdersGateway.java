package com.br.fastBurguer.application.gateways;

import java.util.List;

import com.br.fastBurguer.core.entities.Order;

public interface FindAllOrdersGateway {
    
    public List<Order> findAllOrders();
}
