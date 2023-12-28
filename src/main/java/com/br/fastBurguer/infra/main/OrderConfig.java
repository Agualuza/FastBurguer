package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.adapters.gateways.order.CreateOrderGateway;
import com.br.fastBurguer.adapters.gateways.order.FindAllOrdersGateway;
import com.br.fastBurguer.adapters.gateways.order.FindOrderByPaymentStatusGateway;
import com.br.fastBurguer.adapters.gateways.product.FindProductByIdGateway;
import com.br.fastBurguer.adapters.presenters.order.OrderDTOMapper;
import com.br.fastBurguer.adapters.presenters.order.OrderEntityMapper;
import com.br.fastBurguer.application.useCases.CreateOrder;
import com.br.fastBurguer.application.useCases.CreateQueue;
import com.br.fastBurguer.application.useCases.FindAllOrders;
import com.br.fastBurguer.application.useCases.FindClientById;
import com.br.fastBurguer.application.useCases.FindOrderByPaymentStatus;
import com.br.fastBurguer.infra.gateways.order.CreateOrderRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.FindAllOrdersRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.FindOrderByPaymentStatusRepositoryGateway;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

@Configuration
public class OrderConfig {

    @Bean
    CreateOrder createOrder(CreateOrderGateway createOrderGateway, FindClientById findClientById,
            CreateQueue createQueue) {
        return new CreateOrder(createOrderGateway, findClientById, createQueue);
    }

    @Bean
    FindAllOrders findAllOrders(FindAllOrdersGateway findAllOrdersGateway) {
        return new FindAllOrders(findAllOrdersGateway);
    }

    @Bean
    FindOrderByPaymentStatus findOrderByPaymentStatus(FindOrderByPaymentStatusGateway findOrderByPaymentStatusGateway){
        return new FindOrderByPaymentStatus(findOrderByPaymentStatusGateway);
    }

    @Bean
    CreateOrderGateway createOrderGateway(OrderEntityMapper orderEntityMapper,
            OrderRepository orderRepository) {
        return new CreateOrderRepositoryGateway(orderEntityMapper, orderRepository);
    }

    @Bean
    FindAllOrdersGateway findAllOrdersGateway(OrderEntityMapper orderEntityMapper, OrderRepository orderRepository) {
        return new FindAllOrdersRepositoryGateway(orderEntityMapper, orderRepository);
    }

    @Bean
    FindOrderByPaymentStatusGateway findOrderByPaymentStatusGateway(OrderEntityMapper orderEntityMapper, OrderRepository orderRepository) {
        return new FindOrderByPaymentStatusRepositoryGateway(orderRepository, orderEntityMapper);
    }

    @Bean
    OrderEntityMapper orderEntityMapper() {
        return new OrderEntityMapper();
    }

    @Bean
    OrderDTOMapper orderDTOMapper(FindProductByIdGateway findProductByIdGateway) {
        return new OrderDTOMapper(findProductByIdGateway);
    }

}
