package com.br.fastBurguer.application.gateways;

import java.util.List;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public interface FindQueueByStatusGateway {

    public List<Queue> findQueueByStatus(QueueStatusEnum queueStatusEnum);
}
