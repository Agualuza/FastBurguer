package com.br.fastBurguer.infra.gateways.order;

import com.br.fastBurguer.application.gateways.CreateOrderGateway;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.gateways.client.ClientEntityMapper;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

public class CreateOrderRepositoryGateway implements CreateOrderGateway {

    private final OrderEntityMapper orderEntityMapper;
    private final OrderRepository orderRepository;
    private final ClientEntityMapper clientEntityMapper;

    public CreateOrderRepositoryGateway(OrderEntityMapper orderEntityMapper,
            OrderRepository orderRepository, ClientEntityMapper clientEntityMapper) {
        this.orderEntityMapper = orderEntityMapper;
        this.orderRepository = orderRepository;
        this.clientEntityMapper = clientEntityMapper;
    }

    @Override
    public Order createOrder(Client client, Order order) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(client, order);
        OrderEntity savedObj = orderRepository.save(orderEntity);
        return orderEntityMapper.toDomain(clientEntityMapper.toDomain(savedObj.getClientEntity()), orderEntity);
    }

}
