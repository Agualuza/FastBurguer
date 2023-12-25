package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.application.gateways.EditQueueStatusGateway;
import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public class EditQueueStatus {

    private final EditQueueStatusGateway editQueueStatusGateway;

    public EditQueueStatus(EditQueueStatusGateway editQueueStatusGateway) {
        this.editQueueStatusGateway = editQueueStatusGateway;
    }

    public Queue editQueueStatus(Long id, QueueStatusEnum queueStatusEnum) {
        return editQueueStatusGateway.editQueueStatus(id, queueStatusEnum);
    }
}
