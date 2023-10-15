package com.br.fastBurguer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fastBurguer.domain.order.Order;
import com.br.fastBurguer.domain.queue.Queue;
import com.br.fastBurguer.domain.queue.Enums.StatusEnum;
import com.br.fastBurguer.repository.QueueRepository;

@Service
public class QueueService {

    @Autowired
    QueueRepository queueRepository;
    
    public void createQueue(Order order) {
        Queue queue = new Queue(order, StatusEnum.RECEIVE);
        queueRepository.save(queue);
    }

    public List<Queue> getQueueByStatus(StatusEnum status) {
        List<Queue> queues = queueRepository.findByStatus(StatusEnum.fromString(status.getValue()));
        return queues;
    }

    public void changeStatusQueue(Long id, StatusEnum status) {
        Optional<Queue> queue = queueRepository.findById(id);
        Queue queueToChange = new Queue(queue.get().getId(), queue.get().getOrder(), status);
        queueRepository.save(queueToChange);
    }
}
