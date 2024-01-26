package com.br.fastBurguer.infra.gateways.order;

import com.br.fastBurguer.adapters.gateways.order.EditOrderPaymentStatusGateway;
import com.br.fastBurguer.core.entities.Order;
import com.br.fastBurguer.infra.persistence.order.OrderEntity;
import com.br.fastBurguer.infra.persistence.order.OrderEntityMapper;
import com.br.fastBurguer.infra.persistence.order.OrderRepository;

public class EditOrderPaymentStatusRepositoryGateway implements EditOrderPaymentStatusGateway {

    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    public EditOrderPaymentStatusRepositoryGateway(OrderRepository orderRepository,
            OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public void editOrderPaymentStatus(Order order) {
        OrderEntity orderEntity = orderEntityMapper.toEntityEditPaymentStatus(order);
        orderRepository.save(orderEntity);
    }

}
