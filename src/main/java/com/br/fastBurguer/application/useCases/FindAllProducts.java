package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.product.FindAllProductsGateway;
import com.br.fastBurguer.core.entities.Product;

public class FindAllProducts {

    private final FindAllProductsGateway findAllProductsGateway;

    public FindAllProducts(FindAllProductsGateway findAllProductsGateway) {
        this.findAllProductsGateway = findAllProductsGateway;
    }

    public List<Product> findAllProducts() {
        return findAllProductsGateway.findAllProducts();
    }
}
