package com.br.fastBurguer.infra.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.adapters.boundary.CreateProductBoundary;
import com.br.fastBurguer.adapters.boundary.DeleteProductBoundary;
import com.br.fastBurguer.adapters.boundary.EditProductBoundary;
import com.br.fastBurguer.adapters.boundary.FindAllProductsBoundary;
import com.br.fastBurguer.adapters.boundary.FindProductByCategoryBoundary;
import com.br.fastBurguer.adapters.presenters.product.CreateProductRequest;
import com.br.fastBurguer.adapters.presenters.product.CreateProductResponse;
import com.br.fastBurguer.adapters.presenters.product.EditProductRequest;
import com.br.fastBurguer.adapters.presenters.product.EditProductResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(("/products"))
@Tag(name = "Products", description = "Create, read, update and delete products")
public class ProductController {

        private final CreateProductBoundary createProductBoundary;
        private final EditProductBoundary editProductbBoundary;
        private final FindAllProductsBoundary findAllProductsBoundary;
        private final FindProductByCategoryBoundary findProductByCategoryBoundary;
        private final DeleteProductBoundary deleteProductBoundary;

        public ProductController(CreateProductBoundary createProductBoundary, EditProductBoundary editProductbBoundary,
                        FindAllProductsBoundary findAllProductsBoundary,
                        DeleteProductBoundary deleteProductBoundary,
                        FindProductByCategoryBoundary findProductByCategoryBoundary) {
                this.createProductBoundary = createProductBoundary;
                this.editProductbBoundary = editProductbBoundary;
                this.findAllProductsBoundary = findAllProductsBoundary;
                this.deleteProductBoundary = deleteProductBoundary;
                this.findProductByCategoryBoundary = findProductByCategoryBoundary;
        }

        @Operation(summary = "Get Product")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Get all products", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductRequest.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        })
        })
        @GetMapping()
        public ResponseEntity<List<CreateProductResponse>> getAllProdutcs() {
                try {
                        List<CreateProductResponse> products = findAllProductsBoundary.findAllProducts();
                        return ResponseEntity.ok(products);
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
        }

        @Operation(summary = "Create Product")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Product Created", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductRequest.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        })
        })
        @PostMapping()
        public ResponseEntity<CreateProductResponse> addProduct(
                        @RequestBody CreateProductRequest createProductRequest) {
                try {
                        CreateProductResponse productCreated = createProductBoundary
                                        .createProduct(createProductRequest);
                        return ResponseEntity.ok(productCreated);
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
        }

        @Operation(summary = "Edit Product")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Product Edited", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = EditProductRequest.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        })
        })
        @PutMapping()
        public ResponseEntity<EditProductResponse> editProduct(@RequestBody EditProductRequest editProductRequest) {
                try {
                        EditProductResponse productEdited = editProductbBoundary.editProduct(editProductRequest);
                        return ResponseEntity.ok(productEdited);
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
        }

        @Operation(summary = "Delete Product")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Product Edit", content = {
                                        @Content
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        }),
                        @ApiResponse(responseCode = "404", description = "Not Found", content = {
                                        @Content
                        })
        })
        @DeleteMapping()
        public ResponseEntity<Void> deleteProduct(@RequestParam("id") Long id) {
                try {
                        deleteProductBoundary.deleteProduct(id);
                        return ResponseEntity.ok().build();
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
        }

        @Operation(summary = "Search Product By Category")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Product Found", content = {
                                        @Content
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        }),
                        @ApiResponse(responseCode = "404", description = "Not Found", content = {
                                        @Content
                        })
        })
        @GetMapping("/byCategory")
        public ResponseEntity<List<CreateProductResponse>> getProductByCategory(
                        @RequestParam("category") String category) {
                try {
                        List<CreateProductResponse> products = findProductByCategoryBoundary
                                        .findProductByCategory(category);
                        return ResponseEntity.ok(products);
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
        }

}
