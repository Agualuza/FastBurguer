package com.br.fastBurguer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.domain.products.Product;
import com.br.fastBurguer.domain.products.dto.ProductDto;
import com.br.fastBurguer.domain.products.dto.ProductEditDto;
import com.br.fastBurguer.services.ProductService;

@RestController
@RequestMapping(("/products"))
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAllProdutcs() {
       return productService.getAllProdutcs();
    }

    @PostMapping()
    public void addProduct(@RequestBody ProductDto product) {
        productService.addProduct(product);
    }

    @PutMapping()
    public void editProduct(@RequestBody ProductEditDto product) {
        productService.editProduct(product);
    }

    @DeleteMapping()
    public void deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/byCategory")
    public List<Product> getProductByCategory(@RequestParam("category") String category) {
        return productService.findProductByCategory(category);
    }

}
