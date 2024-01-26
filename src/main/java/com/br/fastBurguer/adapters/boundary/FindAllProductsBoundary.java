package com.br.fastBurguer.adapters.boundary;

import java.util.List;

import com.br.fastBurguer.adapters.presenters.product.CreateProductResponse;

public interface FindAllProductsBoundary {
    
    public List<CreateProductResponse> findAllProducts();
}
