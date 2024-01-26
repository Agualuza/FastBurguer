package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.adapters.gateways.product.CreateProductGateway;
import com.br.fastBurguer.adapters.gateways.product.DeleteProductGateway;
import com.br.fastBurguer.adapters.gateways.product.EditProductGateway;
import com.br.fastBurguer.adapters.gateways.product.FindAllProductsGateway;
import com.br.fastBurguer.adapters.gateways.product.FindProductByCategoryGateway;
import com.br.fastBurguer.adapters.gateways.product.FindProductByIdGateway;
import com.br.fastBurguer.adapters.presenters.product.ProductDTOMapper;
import com.br.fastBurguer.application.useCases.CreateProduct;
import com.br.fastBurguer.application.useCases.DeleteProduct;
import com.br.fastBurguer.application.useCases.EditProduct;
import com.br.fastBurguer.application.useCases.FindAllProducts;
import com.br.fastBurguer.application.useCases.FindProductByCategory;
import com.br.fastBurguer.application.useCases.FindProductById;
import com.br.fastBurguer.infra.gateways.product.CreateProductRepositoryGateway;
import com.br.fastBurguer.infra.gateways.product.DeleteProductRepositoryGateway;
import com.br.fastBurguer.infra.gateways.product.EditProductRepositoryGateway;
import com.br.fastBurguer.infra.gateways.product.FindAllProductsRepositoryGateway;
import com.br.fastBurguer.infra.gateways.product.FindProductByCategoryRepositoryGateway;
import com.br.fastBurguer.infra.gateways.product.FindProductByIdRepositoryGateway;
import com.br.fastBurguer.infra.persistence.products.ProductEntityMapper;
import com.br.fastBurguer.infra.persistence.products.ProdutcRepository;

@Configuration
public class ProductConfig {

    @Bean
    CreateProduct createProduct(CreateProductGateway createProductGateway, ProductDTOMapper productDTOMapper) {
        return new CreateProduct(createProductGateway, productDTOMapper);
    }

    @Bean
    EditProduct editProduct(EditProductGateway editProductGateway, ProductDTOMapper productDTOMapper) {
        return new EditProduct(editProductGateway, productDTOMapper);
    }

    @Bean
    DeleteProduct deleteProduct(DeleteProductGateway deleteProductGateway) {
        return new DeleteProduct(deleteProductGateway);
    }

    @Bean
    FindProductByCategory findProductByCategory(FindProductByCategoryGateway findProductByCategoryGateway, ProductDTOMapper productDTOMapper) {
        return new FindProductByCategory(findProductByCategoryGateway, productDTOMapper);
    }

    @Bean
    FindProductById findProductById(FindProductByIdGateway findProductByIdGateway) {
        return new FindProductById(findProductByIdGateway);
    }

    @Bean
    FindAllProducts findAllProducts(FindAllProductsGateway findAllProductsGateway, ProductDTOMapper productDTOMapper) {
        return new FindAllProducts(findAllProductsGateway, productDTOMapper);
    }

    @Bean
    CreateProductGateway createProductGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        return new CreateProductRepositoryGateway(productEntityMapper, produtcRepository);
    }

    @Bean
    DeleteProductGateway deleteProductGateway(ProdutcRepository produtcRepository) {
        return new DeleteProductRepositoryGateway(produtcRepository);
    }

    @Bean
    EditProductGateway editProductGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        return new EditProductRepositoryGateway(productEntityMapper, produtcRepository);
    }

    @Bean
    FindAllProductsGateway findAllProductsGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        return new FindAllProductsRepositoryGateway(productEntityMapper, produtcRepository);
    }

    @Bean
    FindProductByCategoryGateway findProductByCategoryGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        return new FindProductByCategoryRepositoryGateway(productEntityMapper, produtcRepository);
    }

    @Bean
    FindProductByIdGateway findProductByIdGateway(ProductEntityMapper productEntityMapper,
            ProdutcRepository produtcRepository) {
        return new FindProductByIdRepositoryGateway(productEntityMapper, produtcRepository);
    }

    @Bean
    ProductEntityMapper productEntityMapper() {
        return new ProductEntityMapper();
    }

    @Bean
    ProductDTOMapper productDTOMapper() {
        return new ProductDTOMapper();
    }
}
