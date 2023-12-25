package com.br.fastBurguer.infra.gateways.product;

import com.br.fastBurguer.application.gateways.EditProductGateway;
import com.br.fastBurguer.core.entities.Product;
import com.br.fastBurguer.infra.persistence.products.ProductEntity;
import com.br.fastBurguer.infra.persistence.products.ProdutcRepository;

public class EditProductRepositoryGateway implements EditProductGateway {

    private final ProductEntityMapper productEntityMapper;
    private final ProdutcRepository produtcRepository;

    public EditProductRepositoryGateway(ProductEntityMapper productEntityMapper, ProdutcRepository produtcRepository) {
        this.productEntityMapper = productEntityMapper;
        this.produtcRepository = produtcRepository;
    }

    @Override
    public Product editProduct(Product product) {
        ProductEntity productEntity = productEntityMapper.toEntityEdit(product);
        ProductEntity savedObj = produtcRepository.save(productEntity);
        return productEntityMapper.toDomainEdit(savedObj);
    }
    
}
