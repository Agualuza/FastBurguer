package com.br.fastBurguer.infra.gateways.queue;

import com.br.fastBurguer.adapters.gateways.queue.FindQueueByOrderIdGateway;
import com.br.fastBurguer.adapters.presenters.queue.QueueEntityMapper;
import com.br.fastBurguer.core.entities.Queue;
import com.br.fastBurguer.infra.persistence.queue.QueueEntity;
import com.br.fastBurguer.infra.persistence.queue.QueueRepository;

public class FindQueueByOrderIdRepositoryGateway implements FindQueueByOrderIdGateway {

    private final QueueEntityMapper queueEntityMapper;
    private final QueueRepository queueRepository;

    public FindQueueByOrderIdRepositoryGateway(QueueEntityMapper queueEntityMapper, QueueRepository queueRepository) {
        this.queueEntityMapper = queueEntityMapper;
        this.queueRepository = queueRepository;
    }

    @Override
    public Queue findQueueByOrderId(Long orderId) {
        QueueEntity queueEntity = queueRepository.findByOrderId(orderId);
        Queue queue = queueEntityMapper.toDomainEdit(queueEntity);

        return queue;
    }
    
}
