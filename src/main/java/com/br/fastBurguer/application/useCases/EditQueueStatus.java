package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.EditQueueStatusBoundary;
import com.br.fastBurguer.adapters.gateways.queue.EditQueueStatusGateway;
import com.br.fastBurguer.adapters.presenters.queue.QueueDTOMapper;
import com.br.fastBurguer.adapters.presenters.queue.QueueResponse;
import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public class EditQueueStatus implements EditQueueStatusBoundary {

    private final EditQueueStatusGateway editQueueStatusGateway;
    private final QueueDTOMapper queueDTOMapper;

    public EditQueueStatus(EditQueueStatusGateway editQueueStatusGateway, QueueDTOMapper queueDTOMapper) {
        this.editQueueStatusGateway = editQueueStatusGateway;
        this.queueDTOMapper = queueDTOMapper;
    }

    @Override
    public QueueResponse editQueueStatus(Long orderId, QueueStatusEnum queueStatusEnum) {
        Queue queueFound = editQueueStatusGateway.editQueueStatus(orderId, queueStatusEnum);
        return queueDTOMapper.toResponse(queueFound);
    }
}
