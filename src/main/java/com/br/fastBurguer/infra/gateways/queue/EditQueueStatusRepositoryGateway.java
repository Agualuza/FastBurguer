package com.br.fastBurguer.infra.gateways.queue;

import com.br.fastBurguer.adapters.gateways.queue.EditQueueStatusGateway;
import com.br.fastBurguer.adapters.presenters.queue.QueueEntityMapper;
import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;
import com.br.fastBurguer.infra.persistence.queue.QueueEntity;
import com.br.fastBurguer.infra.persistence.queue.QueueRepository;

public class EditQueueStatusRepositoryGateway implements EditQueueStatusGateway {

    private final QueueEntityMapper queueEntityMapper;
    private final QueueRepository queueRepository;

    public EditQueueStatusRepositoryGateway(QueueEntityMapper queueEntityMapper, QueueRepository queueRepository) {
        this.queueEntityMapper = queueEntityMapper;
        this.queueRepository = queueRepository;
    }

    @Override
    public Queue editQueueStatus(Long orderId, QueueStatusEnum queueStatusEnum) {
        QueueEntity queueEntity = queueRepository.findByOrderId(orderId);
        Queue queue = queueEntityMapper.toDomainEdit(queueEntity);
        QueueEntity queueEntityToSave = queueEntityMapper.toEntityEdit(queue, queueStatusEnum);
        QueueEntity objSaved = queueRepository.save(queueEntityToSave);
        return queueEntityMapper.toDomainEdit(objSaved);
    }

}
