package com.br.fastBurguer.infra.gateways.product;

import com.br.fastBurguer.application.gateways.DeleteProductGateway;
import com.br.fastBurguer.infra.persistence.products.ProdutcRepository;

public class DeleteProductRepositoryGateway implements DeleteProductGateway {

    private final ProdutcRepository produtcRepository;

    public DeleteProductRepositoryGateway(ProdutcRepository produtcRepository) {
        this.produtcRepository = produtcRepository;
    }

    @Override
    public void deleteProduct(Long id) {
        produtcRepository.deleteById(id);
    }

}
