package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.application.gateways.FindAllOrdersGateway;
import com.br.fastBurguer.core.entities.Order;

public class FindAllOrders {

    private final FindAllOrdersGateway findAllOrdersGateway;

    public FindAllOrders(FindAllOrdersGateway findAllOrdersGateway) {
        this.findAllOrdersGateway = findAllOrdersGateway;
    }

    public List<Order> findAllOrders() {
        return findAllOrdersGateway.findAllOrders();
    }
}
