package com.br.fastBurguer.adapters.presenters.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;

public class OrderEntityMapper {

    public OrderEntity toEntity(Long clientId, List<Long> products) {
        return new OrderEntity(clientId, products);
    }

    public Order toDomain(OrderEntity orderEntity) {
        return new Order(orderEntity.getId(), orderEntity.getClientId(), orderEntity.getProducts());
    }

    public Order toDomain(Optional<OrderEntity> orderEntity) {
        return new Order(orderEntity.get().getId(), orderEntity.get().getClientId(), orderEntity.get().getProducts());
    }

    public List<Order> toListDomain(List<OrderEntity> orderEntities) {
        List<Order> itemsToReturn = new ArrayList<>();

        for (OrderEntity orderEntity : orderEntities) {
            Order orderToAdd = toDomain(orderEntity);
            itemsToReturn.add(orderToAdd);
        }

        return itemsToReturn;
    }
}
