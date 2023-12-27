package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.product.FindProductByIdGateway;
import com.br.fastBurguer.core.entities.Product;

public class FindProductById {

    private final FindProductByIdGateway findProductByIdGateway;

    public FindProductById(FindProductByIdGateway findProductByIdGateway) {
        this.findProductByIdGateway = findProductByIdGateway;
    }

    public Product findProductById(Long id) {
        return findProductByIdGateway.findProductById(id);
    }
}
