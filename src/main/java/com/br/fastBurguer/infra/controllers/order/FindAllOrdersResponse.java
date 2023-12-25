package com.br.fastBurguer.infra.controllers.order;

import java.util.List;

import com.br.fastBurguer.core.entities.Order;

public record FindAllOrdersResponse(
    List<Order> orders
) {
}
    

