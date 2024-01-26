package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.adapters.gateways.queue.CreateQueueGateway;
import com.br.fastBurguer.adapters.gateways.queue.EditQueueStatusGateway;
import com.br.fastBurguer.adapters.gateways.queue.FindQueueByOrderIdGateway;
import com.br.fastBurguer.adapters.gateways.queue.FindQueueByStatusGateway;
import com.br.fastBurguer.adapters.presenters.queue.QueueDTOMapper;
import com.br.fastBurguer.application.useCases.CreateQueue;
import com.br.fastBurguer.application.useCases.EditQueueStatus;
import com.br.fastBurguer.application.useCases.FindQueueByOrderId;
import com.br.fastBurguer.application.useCases.FindQueueByStatus;
import com.br.fastBurguer.infra.gateways.queue.CreateQueueRepositoryGateway;
import com.br.fastBurguer.infra.gateways.queue.EditQueueStatusRepositoryGateway;
import com.br.fastBurguer.infra.gateways.queue.FindQueueByOrderIdRepositoryGateway;
import com.br.fastBurguer.infra.gateways.queue.FindQueueByStatusRepository;
import com.br.fastBurguer.infra.persistence.queue.QueueEntityMapper;
import com.br.fastBurguer.infra.persistence.queue.QueueRepository;

@Configuration
public class QueueConfig {

    @Bean
    CreateQueue createQueue(CreateQueueGateway createQueueGateway) {
        return new CreateQueue(createQueueGateway);
    }

    @Bean
    EditQueueStatus editQueueStatus(EditQueueStatusGateway editQueueStatusGateway, QueueDTOMapper queueDTOMapper) {
        return new EditQueueStatus(editQueueStatusGateway, queueDTOMapper);
    }

    @Bean
    FindQueueByStatus findQueueByStatus(FindQueueByStatusGateway findQueueByStatusGateway) {
        return new FindQueueByStatus(findQueueByStatusGateway);
    }

    @Bean
    FindQueueByOrderId findQueueByOrderId(FindQueueByOrderIdGateway findQueueByOrderIdGateway) {
        return new FindQueueByOrderId(findQueueByOrderIdGateway);
    }

    @Bean
    CreateQueueGateway createQueueGateway(QueueEntityMapper queueEntityMapper, QueueRepository queueRepository) {
        return new CreateQueueRepositoryGateway(queueEntityMapper, queueRepository);
    }

    @Bean
    EditQueueStatusGateway editQueueStatusGateway(QueueEntityMapper queueEntityMapper,
            QueueRepository queueRepository) {
        return new EditQueueStatusRepositoryGateway(queueEntityMapper, queueRepository);
    }

    @Bean
    FindQueueByStatusGateway findQueueByStatusGateway(QueueEntityMapper queueEntityMapper,
            QueueRepository queueRepository) {
        return new FindQueueByStatusRepository(queueEntityMapper, queueRepository);
    }

    @Bean
    FindQueueByOrderIdGateway findQueueByOrderIdGateway(QueueEntityMapper queueEntityMapper,
            QueueRepository queueRepository) {
        return new FindQueueByOrderIdRepositoryGateway(queueEntityMapper, queueRepository);
    }

    @Bean
    QueueEntityMapper queueEntityMapper() {
        return new QueueEntityMapper();
    }

    @Bean
    QueueDTOMapper queueDTOMapper() {
        return new QueueDTOMapper();
    }
}
