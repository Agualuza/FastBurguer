package com.br.fastBurguer.adapters.presenters.webhookPayments;

public record SendPaymentApproveRequest(
        Long orderId,
        Boolean paymentStatus) {

}
