package com.br.fastBurguer.infra.gateways.product;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.product.FindProductByCategoryGateway;
import com.br.fastBurguer.core.entities.Product;
import com.br.fastBurguer.infra.persistence.products.ProductEntity;
import com.br.fastBurguer.infra.persistence.products.ProductEntityMapper;
import com.br.fastBurguer.infra.persistence.products.ProdutcRepository;

public class FindProductByCategoryRepositoryGateway implements FindProductByCategoryGateway {

    private final ProductEntityMapper productEntityMapper;
    private final ProdutcRepository produtcRepository;

    public FindProductByCategoryRepositoryGateway(ProductEntityMapper productEntityMapper, ProdutcRepository produtcRepository) {
        this.productEntityMapper = productEntityMapper;
        this.produtcRepository = produtcRepository;
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        List<ProductEntity> productEntityList = produtcRepository.findByType(category);
        return productEntityMapper.toDomainList(productEntityList);
    }

}
