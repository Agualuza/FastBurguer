package com.br.fastBurguer.adapters.gateways.queue;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public interface EditQueueStatusGateway {

    public Queue editQueueStatus(Long id, QueueStatusEnum queueStatusEnum);
}
