package com.br.fastBurguer.infra.controllers.order;

import java.util.List;

public record CreateOrderRequest(
        Long clientId,
        List<Long> products) {

}
