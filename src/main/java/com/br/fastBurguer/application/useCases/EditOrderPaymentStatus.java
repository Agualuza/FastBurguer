package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.EditOrderPaymentStatusBoundary;
import com.br.fastBurguer.adapters.gateways.order.EditOrderPaymentStatusGateway;
import com.br.fastBurguer.adapters.gateways.order.FindOrderGateway;
import com.br.fastBurguer.adapters.presenters.webhookPayments.SendPaymentApproveRequest;
import com.br.fastBurguer.core.entities.Order;

public class EditOrderPaymentStatus implements EditOrderPaymentStatusBoundary {

    private final EditOrderPaymentStatusGateway editOrderPaymentStatus;
    private final FindOrderGateway findOrderGateway;

    public EditOrderPaymentStatus(EditOrderPaymentStatusGateway editOrderPaymentStatus, FindOrderGateway findOrderGateway) {
        this.editOrderPaymentStatus = editOrderPaymentStatus;
        this.findOrderGateway = findOrderGateway;
    }

    @Override
    public void editOrderPaymentStatus(SendPaymentApproveRequest sendPaymentApproveRequest) {
        Order searchOrder = findOrderGateway.findOrder(sendPaymentApproveRequest.orderId());
        searchOrder.setPaymentApproved(sendPaymentApproveRequest.paymentStatus());
        editOrderPaymentStatus.editOrderPaymentStatus(searchOrder);
    }
}
