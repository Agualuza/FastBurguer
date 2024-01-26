package com.br.fastBurguer.infra.gateways.order;

import java.util.Optional;

import com.br.fastBurguer.adapters.gateways.order.FindOrderGateway;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;
import com.br.fastBurguer.infra.persistence.order.OrderEntityMapper;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

public class FindOrderByPaymentStatusRepositoryGateway implements FindOrderGateway {
    
    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    public FindOrderByPaymentStatusRepositoryGateway(OrderRepository orderRepository,
            OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public Order findOrder(Long id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        return orderEntityMapper.toDomain(order);
    }
    
}
