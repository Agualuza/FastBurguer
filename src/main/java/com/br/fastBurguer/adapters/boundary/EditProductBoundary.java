package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.product.EditProductRequest;
import com.br.fastBurguer.adapters.presenters.product.EditProductResponse;

public interface EditProductBoundary {
    
    public EditProductResponse editProduct(EditProductRequest editProductRequest);
}
