package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.boundary.FindProductByCategoryBoundary;
import com.br.fastBurguer.adapters.gateways.product.FindProductByCategoryGateway;
import com.br.fastBurguer.adapters.presenters.product.CreateProductResponse;
import com.br.fastBurguer.adapters.presenters.product.ProductDTOMapper;
import com.br.fastBurguer.core.entities.Product;

public class FindProductByCategory implements FindProductByCategoryBoundary {

    private final FindProductByCategoryGateway findProductByCategoryGateway;
    private final ProductDTOMapper productDTOMapper;

    public FindProductByCategory(FindProductByCategoryGateway findProductByCategoryGateway,
            ProductDTOMapper productDTOMapper) {
        this.findProductByCategoryGateway = findProductByCategoryGateway;
        this.productDTOMapper = productDTOMapper;
    }

    @Override
    public List<CreateProductResponse> findProductByCategory(String category) {
        List<Product> productsFound = findProductByCategoryGateway.findProductByCategory(category);
        return productDTOMapper.toResponse(productsFound);
    }
}
