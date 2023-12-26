package com.br.fastBurguer.infra.controllers.product;

import java.util.ArrayList;
import java.util.List;

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

    public List<CreateProductResponse> toResponse(List<Product> products) {
        List<CreateProductResponse> productsReturn = new ArrayList<>();

        for (Product productToadd : products) {
            CreateProductResponse productToAdd = new CreateProductResponse(productToadd.getId(), productToadd.getName(), productToadd.getDescription(),
                productToadd.getPrice(), productToadd.getType());
            productsReturn.add(productToAdd);
        }

        return productsReturn;
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
