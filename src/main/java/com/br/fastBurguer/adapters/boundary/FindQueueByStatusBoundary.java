package com.br.fastBurguer.adapters.boundary;

import java.util.List;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;
import com.br.fastBurguer.core.entities.Queue;

public interface FindQueueByStatusBoundary {

    public List<Queue> findQueueByStatus(QueueStatusEnum queueStatusEnum);
}
