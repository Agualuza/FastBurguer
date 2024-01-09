package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.adapters.gateways.order.CreateOrderGateway;
import com.br.fastBurguer.adapters.gateways.order.EditOrderPaymentStatusGateway;
import com.br.fastBurguer.adapters.gateways.order.FindAllOrdersGateway;
import com.br.fastBurguer.adapters.gateways.order.FindOrderByProductsGateway;
import com.br.fastBurguer.adapters.gateways.order.FindOrderGateway;
import com.br.fastBurguer.adapters.gateways.product.FindProductByIdGateway;
import com.br.fastBurguer.adapters.presenters.order.OrderDTOMapper;
import com.br.fastBurguer.adapters.presenters.order.OrderEntityMapper;
import com.br.fastBurguer.application.useCases.CreateOrder;
import com.br.fastBurguer.application.useCases.CreateQueue;
import com.br.fastBurguer.application.useCases.EditOrderPaymentStatus;
import com.br.fastBurguer.application.useCases.FindAllOrders;
import com.br.fastBurguer.application.useCases.FindClientById;
import com.br.fastBurguer.application.useCases.FindOrder;
import com.br.fastBurguer.application.useCases.FindOrderByProducts;
import com.br.fastBurguer.application.useCases.FindQueueByOrderId;
import com.br.fastBurguer.infra.gateways.order.CreateOrderRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.EditOrderPaymentStatusRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.FindAllOrdersRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.FindOrderByPaymentStatusRepositoryGateway;
import com.br.fastBurguer.infra.gateways.order.FindOrderByProductsRepositoryGateway;
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
    FindOrder findOrderByPaymentStatus(FindOrderGateway findOrderByPaymentStatusGateway) {
        return new FindOrder(findOrderByPaymentStatusGateway);
    }

    @Bean
    EditOrderPaymentStatus editOrderPaymentStatus(EditOrderPaymentStatusGateway editOrderPaymentStatusGateway,
            FindOrder findOrder) {
        return new EditOrderPaymentStatus(editOrderPaymentStatusGateway, findOrder);
    }

    @Bean
    FindOrderByProducts findOrderByProducts(FindOrderByProductsGateway findOrderByProductsGateway) {
        return new FindOrderByProducts(findOrderByProductsGateway);
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
    FindOrderGateway findOrderByPaymentStatusGateway(OrderEntityMapper orderEntityMapper,
            OrderRepository orderRepository) {
        return new FindOrderByPaymentStatusRepositoryGateway(orderRepository, orderEntityMapper);
    }

    @Bean
    EditOrderPaymentStatusGateway editOrderPaymentStatusGateway(OrderEntityMapper orderEntityMapper,
            OrderRepository orderRepository) {
        return new EditOrderPaymentStatusRepositoryGateway(orderRepository, orderEntityMapper);
    }

    @Bean
    FindOrderByProductsGateway findOrderByProductsGateway(OrderEntityMapper orderEntityMapper,
            OrderRepository orderRepository) {
        return new FindOrderByProductsRepositoryGateway(orderEntityMapper, orderRepository);
    }

    @Bean
    OrderEntityMapper orderEntityMapper() {
        return new OrderEntityMapper();
    }

    @Bean
    OrderDTOMapper orderDTOMapper(FindProductByIdGateway findProductByIdGateway,
            FindQueueByOrderId findQueueByOrderId) {
        return new OrderDTOMapper(findProductByIdGateway, findQueueByOrderId);
    }

}
