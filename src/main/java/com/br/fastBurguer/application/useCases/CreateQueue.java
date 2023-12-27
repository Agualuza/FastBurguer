package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.queue.CreateQueueGateway;
import com.br.fastBurguer.core.entities.Queue;

public class CreateQueue {

    private final CreateQueueGateway createQueueGateway;

    public CreateQueue(CreateQueueGateway createQueueGateway) {
        this.createQueueGateway = createQueueGateway;
    }

    public Queue createQueue(Long orderId) {
        return createQueueGateway.createQueue(orderId);
    }
}
