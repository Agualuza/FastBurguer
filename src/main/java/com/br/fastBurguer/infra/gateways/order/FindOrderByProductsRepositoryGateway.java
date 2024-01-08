package com.br.fastBurguer.infra.gateways.order;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.order.FindOrderByProductsGateway;
import com.br.fastBurguer.adapters.presenters.order.OrderEntityMapper;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

public class FindOrderByProductsRepositoryGateway implements FindOrderByProductsGateway {
    
    private final OrderEntityMapper orderEntityMapper;
    private final OrderRepository orderRepository;

    public FindOrderByProductsRepositoryGateway(OrderEntityMapper orderEntityMapper, OrderRepository orderRepository) {
        this.orderEntityMapper = orderEntityMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findOrderByProducts(List<Long> products) {
        List<OrderEntity> orderEntity = orderRepository.findByProducts(products);
        return orderEntityMapper.toListDomain(orderEntity);
    }


}
