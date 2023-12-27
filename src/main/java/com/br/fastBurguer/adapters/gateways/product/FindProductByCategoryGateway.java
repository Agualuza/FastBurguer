package com.br.fastBurguer.adapters.gateways.product;

import java.util.List;

import com.br.fastBurguer.core.entities.Product;

public interface FindProductByCategoryGateway {

    public List<Product> findProductByCategory(String category);
}
