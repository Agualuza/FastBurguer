package com.br.fastBurguer.infra.gateways.queue;

import com.br.fastBurguer.application.gateways.CreateQueueGateway;
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
    public Queue createQueue(Long orderId) {
        QueueEntity queueEntity = queueEntityMapper.toEntity(orderId);
        QueueEntity savedObj = queueRepository.save(queueEntity);
        return queueEntityMapper.toDomain(savedObj.getId(), orderId, savedObj.getStatus());
    }

}
