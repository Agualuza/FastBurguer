package com.br.fastBurguer.adapters.presenters.queue;

import com.br.fastBurguer.core.Enums.QueueStatusEnum;

public record QueueStatusRequest(
        String queueStatus) {

    public QueueStatusEnum getStatusQueue() {
        return QueueStatusEnum.valueOf(queueStatus);
    }
}
