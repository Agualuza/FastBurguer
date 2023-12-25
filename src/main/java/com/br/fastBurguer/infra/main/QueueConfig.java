package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.application.gateways.CreateQueueGateway;
import com.br.fastBurguer.application.gateways.EditQueueStatusGateway;
import com.br.fastBurguer.application.gateways.FindQueueByStatusGateway;
import com.br.fastBurguer.application.useCases.CreateQueue;
import com.br.fastBurguer.application.useCases.EditQueueStatus;
import com.br.fastBurguer.application.useCases.FindQueueByStatus;
import com.br.fastBurguer.infra.controllers.queue.QueueDTOMapper;
import com.br.fastBurguer.infra.gateways.client.ClientEntityMapper;
import com.br.fastBurguer.infra.gateways.order.OrderEntityMapper;
import com.br.fastBurguer.infra.gateways.queue.CreateQueueRepositoryGateway;
import com.br.fastBurguer.infra.gateways.queue.EditQueueStatusRepositoryGateway;
import com.br.fastBurguer.infra.gateways.queue.FindQueueByStatusRepository;
import com.br.fastBurguer.infra.gateways.queue.QueueEntityMapper;
import com.br.fastBurguer.infra.persistence.queue.QueueRepository;

@Configuration
public class QueueConfig {

    @Bean
    CreateQueue createQueue(CreateQueueGateway createQueueGateway) {
        return new CreateQueue(createQueueGateway);
    }

    @Bean
    EditQueueStatus editQueueStatus(EditQueueStatusGateway editQueueStatusGateway) {
        return new EditQueueStatus(editQueueStatusGateway);
    }

    @Bean
    FindQueueByStatus findQueueByStatus(FindQueueByStatusGateway findQueueByStatusGateway) {
        return new FindQueueByStatus(findQueueByStatusGateway);
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
    QueueEntityMapper queueEntityMapper(OrderEntityMapper orderEntityMapper, ClientEntityMapper clientEntityMapper) {
        return new QueueEntityMapper(orderEntityMapper, clientEntityMapper);
    }

    @Bean
    QueueDTOMapper queueDTOMapper() {
        return new QueueDTOMapper();
    }
}
