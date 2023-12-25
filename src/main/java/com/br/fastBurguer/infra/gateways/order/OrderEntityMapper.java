package com.br.fastBurguer.infra.gateways.order;

import java.util.ArrayList;
import java.util.List;

import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.gateways.client.ClientEntityMapper;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;

public class OrderEntityMapper {

    private final ClientEntityMapper clientEntityMapper;

    public OrderEntityMapper(ClientEntityMapper clientEntityMapper) {
        this.clientEntityMapper = clientEntityMapper;
    }

    public OrderEntity toEntity(Client client, Order orderDomain) {
        return new OrderEntity(clientEntityMapper.toEntity(client), orderDomain.getProducts());
    }

    public Order toDomain(Client client, OrderEntity orderEntity) {
        return new Order(client, orderEntity.getProducts());
    }

    public List<Order> toListDomain(List<OrderEntity> orderEntity) {
        List<Order> itemsToReturn = new ArrayList<>();

        for (OrderEntity order : orderEntity) {
            Order orderToAdd = toDomain(clientEntityMapper.toDomain(order.getClientEntity()), order);
            itemsToReturn.add(orderToAdd);
        }

        return itemsToReturn;
    }
}
