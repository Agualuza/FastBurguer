package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.boundary.FindQueueByStatusBoundary;
import com.br.fastBurguer.adapters.gateways.queue.FindQueueByStatusGateway;
import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public class FindQueueByStatus implements FindQueueByStatusBoundary {

    private final FindQueueByStatusGateway findQueueByStatusGateway;

    public FindQueueByStatus(FindQueueByStatusGateway findQueueByStatusGateway) {
        this.findQueueByStatusGateway = findQueueByStatusGateway;
    }

    @Override
    public List<Queue> findQueueByStatus(QueueStatusEnum queueStatusEnum) {
        return findQueueByStatusGateway.findQueueByStatus(queueStatusEnum);
    }
}
