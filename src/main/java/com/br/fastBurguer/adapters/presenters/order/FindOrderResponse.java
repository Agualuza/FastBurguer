package com.br.fastBurguer.adapters.presenters.order;

import java.util.List;

import com.br.fastBurguer.core.entities.Product;

public record FindOrderResponse(
        Long id,
        Long clientId,
        List<Product> products,
        String orderStatus,
        boolean paymentStatus) {

}
