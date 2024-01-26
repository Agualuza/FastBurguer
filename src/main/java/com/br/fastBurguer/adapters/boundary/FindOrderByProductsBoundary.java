package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.order.FindOrderByProductsRequest;
import com.br.fastBurguer.adapters.presenters.order.FindOrderByProductsResponse;

public interface FindOrderByProductsBoundary {
    
    public FindOrderByProductsResponse findOrderByProducts(FindOrderByProductsRequest findOrderByProductsRequest);
}
