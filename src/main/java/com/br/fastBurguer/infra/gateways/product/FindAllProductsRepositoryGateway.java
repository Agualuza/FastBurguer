package com.br.fastBurguer.infra.gateways.product;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.product.FindAllProductsGateway;
import com.br.fastBurguer.core.entities.Product;
import com.br.fastBurguer.infra.persistence.products.ProductEntity;
import com.br.fastBurguer.infra.persistence.products.ProductEntityMapper;
import com.br.fastBurguer.infra.persistence.products.ProdutcRepository;

public class FindAllProductsRepositoryGateway implements FindAllProductsGateway {

    private final ProductEntityMapper productEntityMapper;
    private final ProdutcRepository produtcRepository;

    public FindAllProductsRepositoryGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        this.productEntityMapper = productEntityMapper;
        this.produtcRepository = produtcRepository;
    }

    @Override
    public List<Product> findAllProducts() {
         List<ProductEntity> productsEntityList = produtcRepository.findAll();
         return productEntityMapper.toDomainList(productsEntityList);
    }
    
}
