package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.order.FindOrderByPaymentStatusResponse;

public interface FindOrderBoundary {
    
    public FindOrderByPaymentStatusResponse findOrder(Long id);
}
