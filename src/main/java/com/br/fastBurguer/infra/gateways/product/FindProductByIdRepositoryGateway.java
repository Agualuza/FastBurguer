package com.br.fastBurguer.infra.gateways.product;

import java.util.Optional;

import com.br.fastBurguer.adapters.gateways.product.FindProductByIdGateway;
import com.br.fastBurguer.core.entities.Product;
import com.br.fastBurguer.infra.persistence.products.ProductEntity;
import com.br.fastBurguer.infra.persistence.products.ProductEntityMapper;
import com.br.fastBurguer.infra.persistence.products.ProdutcRepository;

public class FindProductByIdRepositoryGateway implements FindProductByIdGateway {

    private final ProductEntityMapper productEntityMapper;
    private final ProdutcRepository produtcRepository;

    public FindProductByIdRepositoryGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        this.productEntityMapper = productEntityMapper;
        this.produtcRepository = produtcRepository;
    }

    @Override
    public Product findProductById(Long id) {
        Optional<ProductEntity> productEntity = produtcRepository.findById(id);
        return productEntityMapper.toDomain(productEntity);
    }
    
}
