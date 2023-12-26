package com.br.fastBurguer.infra.gateways.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.core.entities.Queue;
import com.br.fastBurguer.infra.gateways.order.OrderEntityMapper;
import com.br.fastBurguer.infra.persistence.queue.QueueEntity;

public class QueueEntityMapper {

    private final OrderEntityMapper orderEntityMapper;

    public QueueEntityMapper(OrderEntityMapper orderEntityMapper) {
        this.orderEntityMapper = orderEntityMapper;
    }

    public QueueEntity toEntity(Order order) {
        return new QueueEntity(orderEntityMapper.toEntity(order.getClientId(), order.getProducts()),
                QueueStatusEnum.RECEIVE.getValue());
    }

    public Queue toDomain(Order order, String status) {
        return new Queue(order, status);
    }

    public List<Queue> toDomainList(List<QueueEntity> queueEntities) {
        List<Queue> itemsToReturn = new ArrayList<>();

        for (QueueEntity queue : queueEntities) {
            Queue orderToAdd = toDomain(
                    orderEntityMapper.toDomain(queue.getOrderEntity().getClientId(), queue.getOrderEntity()),
                    queue.getStatus());
            itemsToReturn.add(orderToAdd);
        }

        return itemsToReturn;
    }

    public QueueEntity toEntityEdit(Queue queue, QueueStatusEnum statusEnum) {
        return new QueueEntity(queue.getId(),
                orderEntityMapper.toEntity(queue.getOrder().getClientId(), queue.getOrder().getProducts()),
                statusEnum.getValue());
    }

    public Queue toDomainEdit(Optional<QueueEntity> queueEntity) {
        return new Queue(queueEntity.get().getId(), orderEntityMapper
                .toDomain(queueEntity.get().getOrderEntity().getClientId(), queueEntity.get().getOrderEntity()),
                queueEntity.get().getStatus());
    }

    public Queue toDomainEdit(QueueEntity queueEntity) {
        return new Queue(queueEntity.getId(),
                orderEntityMapper.toDomain(queueEntity.getOrderEntity().getClientId(), queueEntity.getOrderEntity()),
                queueEntity.getStatus());
    }
}
