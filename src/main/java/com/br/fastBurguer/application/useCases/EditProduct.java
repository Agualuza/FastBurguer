package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.EditProductBoundary;
import com.br.fastBurguer.adapters.gateways.product.EditProductGateway;
import com.br.fastBurguer.adapters.presenters.product.EditProductRequest;
import com.br.fastBurguer.adapters.presenters.product.EditProductResponse;
import com.br.fastBurguer.adapters.presenters.product.ProductDTOMapper;
import com.br.fastBurguer.core.entities.Product;

public class EditProduct implements EditProductBoundary {

    private final EditProductGateway editProductGateway;
    private final ProductDTOMapper productDTOMapper;

    public EditProduct(EditProductGateway editProductGateway, ProductDTOMapper productDTOMapper) {
        this.editProductGateway = editProductGateway;
        this.productDTOMapper = productDTOMapper;
    }

    @Override
    public EditProductResponse editProduct(EditProductRequest editProductRequest) {
        Product productToEdit = new Product(editProductRequest.id(), editProductRequest.name(),
                editProductRequest.description(), editProductRequest.price(), editProductRequest.type().getValue());

        Product productEdited = editProductGateway.editProduct(productToEdit);
        return productDTOMapper.toEditResponse(productEdited);
    }
}
