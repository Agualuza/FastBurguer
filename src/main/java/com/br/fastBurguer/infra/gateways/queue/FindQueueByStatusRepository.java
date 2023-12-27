package com.br.fastBurguer.infra.gateways.queue;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.queue.FindQueueByStatusGateway;
import com.br.fastBurguer.adapters.presenters.queue.QueueEntityMapper;
import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;
import com.br.fastBurguer.infra.persistence.queue.QueueEntity;
import com.br.fastBurguer.infra.persistence.queue.QueueRepository;

public class FindQueueByStatusRepository implements FindQueueByStatusGateway {

    private final QueueEntityMapper queueEntityMapper;
    private final QueueRepository queueRepository;

    public FindQueueByStatusRepository(QueueEntityMapper queueEntityMapper, QueueRepository queueRepository) {
        this.queueEntityMapper = queueEntityMapper;
        this.queueRepository = queueRepository;
    }

    @Override
    public List<Queue> findQueueByStatus(QueueStatusEnum queueStatusEnum) {
        List<QueueEntity> queueEntitiesList = queueRepository.findByStatus(queueStatusEnum.getValue());
        return queueEntityMapper.toDomainList(queueEntitiesList);
    }
    
}
