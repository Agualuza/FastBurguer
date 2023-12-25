package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.application.gateways.FindProductByCategoryGateway;
import com.br.fastBurguer.core.entities.Product;

public class FindProductByCategory {

    private final FindProductByCategoryGateway findProductByCategoryGateway;

    public FindProductByCategory(FindProductByCategoryGateway findProductByCategoryGateway) {
        this.findProductByCategoryGateway = findProductByCategoryGateway;
    }

    public List<Product> findProductByCategory(String category) {
        return findProductByCategoryGateway.findProductByCategory(category);
    }
}
