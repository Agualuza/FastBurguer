package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.boundary.FindAllProductsBoundary;
import com.br.fastBurguer.adapters.gateways.product.FindAllProductsGateway;
import com.br.fastBurguer.adapters.presenters.product.CreateProductResponse;
import com.br.fastBurguer.adapters.presenters.product.ProductDTOMapper;
import com.br.fastBurguer.core.entities.Product;

public class FindAllProducts implements FindAllProductsBoundary {

    private final FindAllProductsGateway findAllProductsGateway;
    private final ProductDTOMapper productDTOMapper;

    public FindAllProducts(FindAllProductsGateway findAllProductsGateway, ProductDTOMapper productDTOMapper) {
        this.findAllProductsGateway = findAllProductsGateway;
        this.productDTOMapper = productDTOMapper;
    }

    @Override
    public List<CreateProductResponse> findAllProducts() {
        List<Product> products = findAllProductsGateway.findAllProducts();
        return productDTOMapper.toResponse(products);
    }
}
