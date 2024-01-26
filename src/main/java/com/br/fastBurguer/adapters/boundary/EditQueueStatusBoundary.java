package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.queue.QueueResponse;
import com.br.fastBurguer.core.Enums.QueueStatusEnum;

public interface EditQueueStatusBoundary {

    public QueueResponse editQueueStatus(Long orderId, QueueStatusEnum queueStatusEnum);
}
