package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.application.gateways.CreateOrderGateway;
import com.br.fastBurguer.application.gateways.FindAllOrdersGateway;
import com.br.fastBurguer.application.gateways.FindProductByIdGateway;
import com.br.fastBurguer.application.useCases.CreateOrder;
import com.br.fastBurguer.application.useCases.FindAllOrders;
import com.br.fastBurguer.application.useCases.FindClientById;
import com.br.fastBurguer.infra.controllers.order.OrderDTOMapper;
import com.br.fastBurguer.infra.gateways.client.ClientEntityMapper;
import com.br.fastBurguer.infra.gateways.order.CreateOrderRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.FindAllOrdersRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.OrderEntityMapper;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

@Configuration
public class OrderConfig {

    @Bean
    CreateOrder createOrder(CreateOrderGateway createOrderGateway, FindClientById findClientById) {
        return new CreateOrder(createOrderGateway, findClientById);
    }

    @Bean
    FindAllOrders findAllOrders(FindAllOrdersGateway findAllOrdersGateway) {
        return new FindAllOrders(findAllOrdersGateway);
    }

    @Bean
    CreateOrderGateway createOrderGateway(OrderEntityMapper orderEntityMapper,
            OrderRepository orderRepository, ClientEntityMapper clientEntityMapper) {
        return new CreateOrderRepositoryGateway(orderEntityMapper, orderRepository, clientEntityMapper);
    }

    @Bean
    FindAllOrdersGateway findAllOrdersGateway(OrderEntityMapper orderEntityMapper, OrderRepository orderRepository) {
        return new FindAllOrdersRepositoryGateway(orderEntityMapper, orderRepository);
    }

    @Bean
    OrderEntityMapper orderEntityMapper(ClientEntityMapper clientEntityMapper) {
        return new OrderEntityMapper(clientEntityMapper);
    }

    @Bean
    OrderDTOMapper orderDTOMapper(FindProductByIdGateway findProductByIdGateway) {
        return new OrderDTOMapper(findProductByIdGateway);
    }

}
