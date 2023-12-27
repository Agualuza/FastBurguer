package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.product.CreateProductGateway;
import com.br.fastBurguer.core.entities.Product;

public class CreateProduct {
    
    private final CreateProductGateway createProductGateway;

    public CreateProduct(CreateProductGateway createProductGateway) {
        this.createProductGateway = createProductGateway;
    }

    public Product createProduct(Product product) {
        return createProductGateway.createProduct(product);
    }
}
