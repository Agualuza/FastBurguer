package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Product;

public interface FindProductByIdGateway {

    public Product findProductById(Long id);
}
