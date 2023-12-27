package com.br.fastBurguer.adapters.presenters.order;

import java.util.List;

import com.br.fastBurguer.core.entities.Order;

public record FindAllOrdersResponse(
    List<Order> orders
) {
}
    

