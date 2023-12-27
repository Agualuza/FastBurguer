package com.br.fastBurguer.adapters.gateways.product;

import com.br.fastBurguer.core.entities.Product;

public interface FindProductByIdGateway {

    public Product findProductById(Long id);
}
