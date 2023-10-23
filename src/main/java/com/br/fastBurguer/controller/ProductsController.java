package com.br.fastBurguer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(("/products"))
@Tag(name = "Products", description = "Create, read, update and delete products")
public class ProductsController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Get Product")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Get all products",
            content = {
                @Content(mediaType = "application/json",
                schema = @Schema(implementation = ProductDto.class))
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProdutcs() {
        List<Product> products = productService.getAllProdutcs();
        return ResponseEntity.ok().body(products);
    }

    @Operation(summary = "Create Product")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Product Created",
            content = {
                @Content(mediaType = "application/json",
                schema = @Schema(implementation = ProductDto.class))
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
    @PostMapping()
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        productService.addProduct(product);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Edit Product")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product Edited",
            content = {
                @Content(mediaType = "application/json",
                schema = @Schema(implementation = ProductEditDto.class))
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
    @PutMapping()
    public ResponseEntity<ProductEditDto> editProduct(@RequestBody ProductEditDto product) {
        productService.editProduct(product);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Delete Product")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product Edit",
            content = {
                @Content
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Not Found",
            content = {
                @Content
            }
        )
    })
    @DeleteMapping()
    public ResponseEntity<Void> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search Product By Category")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product Found",
            content = {
                @Content
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Not Found",
            content = {
                @Content
            }
        )
    })
    @GetMapping("/byCategory")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam("category") String category) {
        List<Product> products = productService.findProductByCategory(category);
        return ResponseEntity.ok().body(products);
    }

}
