package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.order.FindOrderByProductsGateway;
import com.br.fastBurguer.core.entities.Order;

public class FindOrderByProducts {

    private final FindOrderByProductsGateway findOrderByProductsGateway;

    public FindOrderByProducts(FindOrderByProductsGateway findOrderByProductsGateway) {
        this.findOrderByProductsGateway = findOrderByProductsGateway;
    }

    public List<Order> findOrderByProducts(List<Long> products) {
        return findOrderByProductsGateway.findOrderByProducts(products);
    }
}
