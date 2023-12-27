package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.product.DeleteProductGateway;

public class DeleteProduct {

    private final DeleteProductGateway deleteProductGateway;

    public DeleteProduct(DeleteProductGateway deleteProductGateway) {
        this.deleteProductGateway = deleteProductGateway;
    }

    public void deleteProduct(Long id) {
        deleteProductGateway.deleteProduct(id);
    }
}
