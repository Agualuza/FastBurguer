package com.br.fastBurguer.infra.gateways.product;

import com.br.fastBurguer.adapters.gateways.product.CreateProductGateway;
import com.br.fastBurguer.adapters.presenters.product.ProductEntityMapper;
import com.br.fastBurguer.core.entities.Product;
import com.br.fastBurguer.infra.persistence.products.ProductEntity;
import com.br.fastBurguer.infra.persistence.products.ProdutcRepository;

public class CreateProductRepositoryGateway implements CreateProductGateway {

    private final ProductEntityMapper productEntityMapper;
    private final ProdutcRepository produtcRepository;

    public CreateProductRepositoryGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        this.productEntityMapper = productEntityMapper;
        this.produtcRepository = produtcRepository;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = productEntityMapper.toEntity(product);
        ProductEntity savedObj = produtcRepository.save(productEntity);
        return productEntityMapper.toDomain(savedObj);
    }
    

}
