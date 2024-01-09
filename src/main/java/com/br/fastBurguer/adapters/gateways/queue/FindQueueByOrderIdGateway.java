package com.br.fastBurguer.adapters.gateways.queue;

import com.br.fastBurguer.core.entities.Queue;

public interface FindQueueByOrderIdGateway {

    public Queue findQueueByOrderId(Long orderId);
}
