package com.br.fastBurguer.adapters.gateways.order;

import java.util.List;

import com.br.fastBurguer.core.entities.Order;

public interface FindOrderByProductsGateway {
    
    public List<Order> findOrderByProducts(List<Long> products);
}
