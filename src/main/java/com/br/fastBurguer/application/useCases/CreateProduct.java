package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.CreateProductBoundary;
import com.br.fastBurguer.adapters.gateways.product.CreateProductGateway;
import com.br.fastBurguer.adapters.presenters.product.CreateProductRequest;
import com.br.fastBurguer.adapters.presenters.product.CreateProductResponse;
import com.br.fastBurguer.adapters.presenters.product.ProductDTOMapper;
import com.br.fastBurguer.core.entities.Product;

public class CreateProduct implements CreateProductBoundary {
    
    private final CreateProductGateway createProductGateway;
    private final ProductDTOMapper productDTOMapper;

    public CreateProduct(CreateProductGateway createProductGateway, ProductDTOMapper productDTOMapper) {
        this.createProductGateway = createProductGateway;
        this.productDTOMapper = productDTOMapper;
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProduct) {
        Product productToCreate = new Product(createProduct.name(), createProduct.description(), createProduct.price(), createProduct.type().getValue());
        Product productCreated = createProductGateway.createProduct(productToCreate);

        return productDTOMapper.toResponse(productCreated);
    }
}
