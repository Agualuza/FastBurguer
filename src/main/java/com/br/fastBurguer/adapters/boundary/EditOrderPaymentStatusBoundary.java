package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.webhookPayments.SendPaymentApproveRequest;

public interface EditOrderPaymentStatusBoundary {

    public void editOrderPaymentStatus(SendPaymentApproveRequest sendPaymentApproveRequest);

}
