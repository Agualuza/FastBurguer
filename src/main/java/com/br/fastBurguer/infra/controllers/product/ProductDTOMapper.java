package com.br.fastBurguer.infra.controllers.product;

import com.br.fastBurguer.core.entities.Product;

public class ProductDTOMapper {

    public Product toDomain(CreateProductRequest createProductRequest) {
        return new Product(createProductRequest.name(), createProductRequest.description(),
                createProductRequest.price(), createProductRequest.type().getValue());
    }

    public CreateProductResponse toResponse(Product product) {
        return new CreateProductResponse(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getType());
    }

    public Product toDomainEdit(EditProductRequest editProductRequest) {
        return new Product(editProductRequest.id(), editProductRequest.name(), editProductRequest.description(),
                editProductRequest.price(), editProductRequest.type().getValue());
    }

    public EditProductResponse toEditResponse(Product product) {
        return new EditProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getType());
    }
}
