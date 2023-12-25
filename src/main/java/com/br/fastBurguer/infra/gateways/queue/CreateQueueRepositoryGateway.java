package com.br.fastBurguer.infra.gateways.queue;

import com.br.fastBurguer.application.gateways.CreateQueueGateway;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.core.entities.Queue;
import com.br.fastBurguer.infra.persistence.queue.QueueEntity;
import com.br.fastBurguer.infra.persistence.queue.QueueRepository;

public class CreateQueueRepositoryGateway implements CreateQueueGateway {

    private final QueueEntityMapper queueEntityMapper;
    private final QueueRepository queueRepository;

    public CreateQueueRepositoryGateway(QueueEntityMapper queueEntityMapper, QueueRepository queueRepository) {
        this.queueEntityMapper = queueEntityMapper;
        this.queueRepository = queueRepository;
    }

    @Override
    public Queue createQueue(Order order) {
        QueueEntity queueEntity = queueEntityMapper.toEntity(order);
        QueueEntity savedObj = queueRepository.save(queueEntity);
        return queueEntityMapper.toDomain(order, savedObj.getStatus());
    }

}
