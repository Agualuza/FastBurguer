package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Product;

public interface CreateProductGateway {

    public Product createProduct(Product product);
}
