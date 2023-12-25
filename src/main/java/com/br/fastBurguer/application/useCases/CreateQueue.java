package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.application.gateways.CreateQueueGateway;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.core.entities.Queue;

public class CreateQueue {

    private final CreateQueueGateway createQueueGateway;

    public CreateQueue(CreateQueueGateway createQueueGateway) {
        this.createQueueGateway = createQueueGateway;
    }

    public Queue createQueue(Order order) {
        return createQueueGateway.createQueue(order);
    }
}
