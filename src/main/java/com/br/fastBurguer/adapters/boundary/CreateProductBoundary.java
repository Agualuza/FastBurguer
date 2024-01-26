package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.product.CreateProductRequest;
import com.br.fastBurguer.adapters.presenters.product.CreateProductResponse;

public interface CreateProductBoundary {
    
    public CreateProductResponse createProduct(CreateProductRequest createProduct);
}
