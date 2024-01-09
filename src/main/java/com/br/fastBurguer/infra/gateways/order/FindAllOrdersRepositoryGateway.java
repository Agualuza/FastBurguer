package com.br.fastBurguer.infra.gateways.order;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.order.FindAllOrdersGateway;
import com.br.fastBurguer.adapters.presenters.order.OrderEntityMapper;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

public class FindAllOrdersRepositoryGateway implements FindAllOrdersGateway {
    
    private final OrderEntityMapper orderEntityMapper;
    private final OrderRepository orderRepository;

    public FindAllOrdersRepositoryGateway(OrderEntityMapper orderEntityMapper, OrderRepository orderRepository) {
        this.orderEntityMapper = orderEntityMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAllOrders() {
        List<OrderEntity> ordersFound = orderRepository.findAllByOrderByCreatedAtAsc();
        return orderEntityMapper.toListDomain(ordersFound);
    }

    
    
}
