package com.vamshi.ecommerce.controller;

import com.vamshi.ecommerce.entity.Product;
import com.vamshi.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/bulk")
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product){
        return productService.updateProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
         productService.deleteProduct(id);
         return "Product deleted with id :" + id;
    }
}
