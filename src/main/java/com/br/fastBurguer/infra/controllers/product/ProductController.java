package com.br.fastBurguer.infra.controllers.product;

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

import com.br.fastBurguer.application.useCases.CreateProduct;
import com.br.fastBurguer.application.useCases.DeleteProduct;
import com.br.fastBurguer.application.useCases.EditProduct;
import com.br.fastBurguer.application.useCases.FindAllProducts;
import com.br.fastBurguer.application.useCases.FindProductByCategory;
import com.br.fastBurguer.core.entities.Product;

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

    private final CreateProduct createProduct;
    private final EditProduct editProduct;
    private final FindAllProducts findAllProducts;
    private final FindProductByCategory findProductByCategory;
    private final DeleteProduct deleteProduct;
    private final ProductDTOMapper productDTOMapper;

    public ProductController(CreateProduct createProduct, EditProduct editProduct, FindAllProducts findAllProducts,
            ProductDTOMapper productDTOMapper, DeleteProduct deleteProduct,
            FindProductByCategory findProductByCategory) {
        this.createProduct = createProduct;
        this.editProduct = editProduct;
        this.findAllProducts = findAllProducts;
        this.productDTOMapper = productDTOMapper;
        this.deleteProduct = deleteProduct;
        this.findProductByCategory = findProductByCategory;
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
    public ResponseEntity<List<Product>> getAllProdutcs() {
        List<Product> products = findAllProducts.findAllProducts();
        return ResponseEntity.ok().body(products);
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
    public ResponseEntity<CreateProductResponse> addProduct(@RequestBody CreateProductRequest createProductRequest) {
        Product productToCreate = productDTOMapper.toDomain(createProductRequest);
        Product productCreated = createProduct.createProduct(productToCreate);
        return ResponseEntity.ok().body(productDTOMapper.toResponse(productCreated));
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
        Product productToEdit = productDTOMapper.toDomainEdit(editProductRequest);
        Product productEdited = editProduct.editProduct(productToEdit);
        return ResponseEntity.ok().body(productDTOMapper.toEditResponse(productEdited));
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
        deleteProduct.deleteProduct(id);
        return ResponseEntity.ok().build();
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
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam("category") String category) {
        List<Product> products = findProductByCategory.findProductByCategory(category);
        return ResponseEntity.ok().body(products);
    }

}
