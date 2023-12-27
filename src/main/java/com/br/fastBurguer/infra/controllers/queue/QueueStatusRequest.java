package com.br.fastBurguer.infra.controllers.queue;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;

public record QueueStatusRequest(
        String queueStatus) {

    public QueueStatusEnum getStatusQueue() {
        return QueueStatusEnum.valueOf(queueStatus);
    }
}
