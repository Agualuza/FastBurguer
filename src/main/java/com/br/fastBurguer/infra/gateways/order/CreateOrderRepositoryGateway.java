package com.br.fastBurguer.infra.gateways.order;

import java.util.List;

import com.br.fastBurguer.application.gateways.CreateOrderGateway;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

public class CreateOrderRepositoryGateway implements CreateOrderGateway {

    private final OrderEntityMapper orderEntityMapper;
    private final OrderRepository orderRepository;

    public CreateOrderRepositoryGateway(OrderEntityMapper orderEntityMapper,
            OrderRepository orderRepository) {
        this.orderEntityMapper = orderEntityMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Long clientId, List<String> products) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(clientId, products);
        OrderEntity savedObj = orderRepository.save(orderEntity);
        return orderEntityMapper.toDomain(savedObj.getClientId(), orderEntity);
    }

}