package com.br.fastBurguer.adapters.presenters.order;

import java.util.ArrayList;
import java.util.List;

import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;

public class OrderEntityMapper {

    public OrderEntity toEntity(Long clientId, List<String> products) {
        return new OrderEntity(clientId, products);
    }

    public Order toDomain(Long clientId, OrderEntity orderEntity) {
        return new Order(orderEntity.getId(), clientId, orderEntity.getProducts());
    }

    public List<Order> toListDomain(List<OrderEntity> orderEntity) {
        List<Order> itemsToReturn = new ArrayList<>();

        for (OrderEntity order : orderEntity) {
            Order orderToAdd = toDomain(order.getClientId(), order);
            itemsToReturn.add(orderToAdd);
        }

        return itemsToReturn;
    }
}
