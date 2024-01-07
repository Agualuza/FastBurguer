package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.queue.EditQueueStatusGateway;
import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public class EditQueueStatus {

    private final EditQueueStatusGateway editQueueStatusGateway;

    public EditQueueStatus(EditQueueStatusGateway editQueueStatusGateway) {
        this.editQueueStatusGateway = editQueueStatusGateway;
    }

    public Queue editQueueStatus(Long orderId, QueueStatusEnum queueStatusEnum) {
        return editQueueStatusGateway.editQueueStatus(orderId, queueStatusEnum);
    }
}
