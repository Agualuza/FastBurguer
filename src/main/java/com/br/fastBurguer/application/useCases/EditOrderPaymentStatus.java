package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.order.EditOrderPaymentStatusGateway;
import com.br.fastBurguer.core.entities.Order;

public class EditOrderPaymentStatus {

    private final EditOrderPaymentStatusGateway editOrderPaymentStatus;
    private final FindOrder findOrder;

    public EditOrderPaymentStatus(EditOrderPaymentStatusGateway editOrderPaymentStatus, FindOrder findOrder) {
        this.editOrderPaymentStatus = editOrderPaymentStatus;
        this.findOrder = findOrder;
    }

    public void editOrderPaymentStatus(Long orderId, boolean status) {
        Order searchOrder = findOrder.findOrder(orderId);
        searchOrder.setPaymentApproved(status);
        editOrderPaymentStatus.editOrderPaymentStatus(searchOrder);
    }
}
