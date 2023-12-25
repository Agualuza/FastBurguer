package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.core.entities.Queue;

public interface CreateQueueGateway {

    public Queue createQueue(Order order);
}
