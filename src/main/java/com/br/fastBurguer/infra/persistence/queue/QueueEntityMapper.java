package com.br.fastBurguer.infra.persistence.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public class QueueEntityMapper {

    public QueueEntity toEntity(Long id) {
        return new QueueEntity(id, QueueStatusEnum.RECEIVE.getValue());
    }

    public Queue toDomain(Long id, Long orderId, String status) {
        return new Queue(id, orderId, status);
    }

    public List<Queue> toDomainList(List<QueueEntity> queueEntities) {
        List<Queue> itemsToReturn = new ArrayList<>();

        for (QueueEntity queue : queueEntities) {
            Queue queueToAdd = toDomain(queue.getId() ,queue.getOrderId(), queue.getStatus());
            itemsToReturn.add(queueToAdd);
        }

        return itemsToReturn;
    }

    public QueueEntity toEntityEdit(Queue queue, QueueStatusEnum statusEnum) {
        return new QueueEntity(queue.getId(), queue.getOrderId() ,statusEnum.getValue());
    }

    public Queue toDomainEdit(Optional<QueueEntity> queueEntity) {
        return new Queue(queueEntity.get().getId(), queueEntity.get().getOrderId(),
                queueEntity.get().getStatus());
    }

    public Queue toDomainEdit(QueueEntity queueEntity) {
        return new Queue(queueEntity.getId(), queueEntity.getOrderId(),
                queueEntity.getStatus());
    }
}
