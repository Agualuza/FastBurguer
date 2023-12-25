package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.application.gateways.EditProductGateway;
import com.br.fastBurguer.core.entities.Product;

public class EditProduct {
    
    private final EditProductGateway editProductGateway;

    public EditProduct(EditProductGateway editProductGateway) {
        this.editProductGateway = editProductGateway;
    }

    public Product editProduct(Product product) {
        return editProductGateway.editProduct(product);
    }
}
