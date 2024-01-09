package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.queue.FindQueueByOrderIdGateway;
import com.br.fastBurguer.core.entities.Queue;

public class FindQueueByOrderId {

    private final FindQueueByOrderIdGateway findQueueByOrderIdGateway;

    public FindQueueByOrderId(FindQueueByOrderIdGateway findQueueByOrderIdGateway) {
        this.findQueueByOrderIdGateway = findQueueByOrderIdGateway;
    }

    public Queue findQueueByOrderId(Long id) {
        return findQueueByOrderIdGateway.findQueueByOrderId(id);
    }
}
