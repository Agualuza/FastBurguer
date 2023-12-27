package com.br.fastBurguer.adapters.presenters.queue;

import com.br.fastBurguer.core.entities.Queue;

public class QueueDTOMapper {

    public QueueResponse toResponse(Queue queue) {
        return new QueueResponse(queue.getId(), queue.getStatus());
    }

}
