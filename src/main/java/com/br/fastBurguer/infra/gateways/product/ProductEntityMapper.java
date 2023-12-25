package com.br.fastBurguer.infra.gateways.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.br.fastBurguer.core.entities.Product;
import com.br.fastBurguer.infra.persistence.products.ProductEntity;

public class ProductEntityMapper {

    public ProductEntity toEntity(Product product) {
        return new ProductEntity(product.getName(), product.getDescription(), product.getPrice(), product.getType());
    }

    public Product toDomain(ProductEntity productEntity) {
        return new Product(productEntity.getName(), productEntity.getDescription(), productEntity.getPrice(), productEntity.getType());
    }

    public Product toDomain(Optional<ProductEntity> productEntity) {
        return new Product(productEntity.get().getName(), productEntity.get().getDescription(), productEntity.get().getPrice(), productEntity.get().getType());
    }

    public ProductEntity toEntityEdit(Product product) {
        return new ProductEntity(product.getId() ,product.getName(), product.getDescription(), product.getPrice(), product.getType());
    }

    public Product toDomainEdit(ProductEntity productEntity) {
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription(), productEntity.getPrice(), productEntity.getType());
    }

    public List<Product> toDomainList(List<ProductEntity> productsEntityList) {
        List<Product> productsListDomain = new ArrayList<>();

        for (ProductEntity productEntity : productsEntityList) {
            Product productToAdd = toDomainEdit(productEntity);
            productsListDomain.add(productToAdd);                    
        }

        return productsListDomain;
    }
}
