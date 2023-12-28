package com.br.fastBurguer.adapters.presenters.order;

public record FindOrderByPaymentStatusResponse(
        Long orderId,
        boolean paymentApproved) {

}
