package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.DeleteProductBoundary;
import com.br.fastBurguer.adapters.gateways.product.DeleteProductGateway;

public class DeleteProduct implements DeleteProductBoundary {

    private final DeleteProductGateway deleteProductGateway;

    public DeleteProduct(DeleteProductGateway deleteProductGateway) {
        this.deleteProductGateway = deleteProductGateway;
    }

    @Override
    public void deleteProduct(Long id) {
        deleteProductGateway.deleteProduct(id);
    }
}
