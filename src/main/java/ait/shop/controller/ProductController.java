package ait.shop.controller;

import ait.shop.model.entity.Product;
import ait.shop.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product Controller", description = "Controller for operations with products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Operation(summary = "Create product", description = "Add new product.", tags = {"Product"})
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)),
                    @Content(mediaType = "application/xml", schema = @Schema(implementation = Product.class))})})

    @PostMapping
    public Product saveProduct(@Parameter(description = "Create product object") @RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllActiveProducts();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{productId}")
    public Product remove(@PathVariable("productId") Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/by-title")
    public Product removeByTitle(@RequestParam String title) {
        return service.deleteByTitle(title);
    }

    @PutMapping("/restore/{id}")
    public Product restoreById(@PathVariable Long id) {
        return service.restoreProductById(id);
    }

    @GetMapping("/count")
    public long getProductCount() {
        return service.getProductCount();
    }

    @GetMapping("/total-price/")
    public BigDecimal getTotalPrice() {
        return service.getTotalPrice();
    }

    @GetMapping("/average-price")
    public BigDecimal getAveragePrice() {
        return service.averagePrice();
    }
}


