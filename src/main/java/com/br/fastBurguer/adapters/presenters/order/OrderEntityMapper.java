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

    public OrderEntity toEntityEdit(Order order) {
        return new OrderEntity(order.getId(), order.getClientId(), order.getProducts());
    }

    public OrderEntity toEntityEditPaymentStatus(Order order) {
        return new OrderEntity(order.getId(), order.getClientId(), order.getProducts(), order.isPaymentApproved());
    }

    public Order toDomain(OrderEntity orderEntity) {
        return new Order(orderEntity.getId(), orderEntity.getClientId(), orderEntity.getProducts(),
                orderEntity.isPaymentApproved(), orderEntity.getCreatedAt());
    }

    public Order toDomain(Optional<OrderEntity> orderEntity) {
        return new Order(orderEntity.get().getId(), orderEntity.get().getClientId(), orderEntity.get().getProducts(),
                orderEntity.get().isPaymentApproved(), orderEntity.get().getCreatedAt());
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
