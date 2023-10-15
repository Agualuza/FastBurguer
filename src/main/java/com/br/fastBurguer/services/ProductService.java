package com.br.fastBurguer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fastBurguer.domain.products.Product;
import com.br.fastBurguer.domain.products.dto.ProductDto;
import com.br.fastBurguer.domain.products.dto.ProductEditDto;
import com.br.fastBurguer.domain.products.enums.ProductEnum;
import com.br.fastBurguer.repository.ProdutcRepository;

@Service
public class ProductService {

    @Autowired
    ProdutcRepository produtcRepository;

    public List<Product> getAllProdutcs() {
        List<Product> arrayItems = produtcRepository.findAll();

        List<Product> itemsToReturn = new ArrayList<>();

        for (Product product : arrayItems) {
            Product productToAdd = new Product(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                    ProductEnum.fromString(product.getType()));
            itemsToReturn.add(productToAdd);                    
            System.out.println(productToAdd);
        }

        return itemsToReturn;
    }

    public void addProduct(ProductDto product) {
        Product productToPersist = new Product(product.name(), product.description(), product.price(), product.type());
        produtcRepository.save(productToPersist);
    }

    public void editProduct(ProductEditDto product) {
        Product productToPersist = new Product(product.id(),product.name(), product.description(), product.price(),ProductEnum.fromString(product.type()));
        produtcRepository.save(productToPersist);
    }

    public void deleteProduct(Long id) {
        produtcRepository.deleteById(id);
    }

    public List<Product> findProductByCategory(String category) {
        return produtcRepository.findByType(category);
    }

    public Optional<Product> findProductById(Long id) {
        return produtcRepository.findById(id);
    }
}
