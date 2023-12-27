package com.br.fastBurguer.adapters.presenters.order;

import java.util.List;

public record CreateOrderRequest(
        Long clientId,
        List<Long> products) {

}
