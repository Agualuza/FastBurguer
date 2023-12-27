package com.br.fastBurguer.adapters.gateways.queue;

import com.br.fastBurguer.core.entities.Queue;

public interface CreateQueueGateway {

    public Queue createQueue(Long orderId);
}
