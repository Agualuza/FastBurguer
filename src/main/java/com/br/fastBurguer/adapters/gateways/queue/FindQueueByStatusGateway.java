package com.br.fastBurguer.adapters.gateways.queue;

import java.util.List;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public interface FindQueueByStatusGateway {

    public List<Queue> findQueueByStatus(QueueStatusEnum queueStatusEnum);
}
