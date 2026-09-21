package com.vamshi.ecommerce.service;

import com.vamshi.ecommerce.entity.Product;
import com.vamshi.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    //CREATE
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    //GET ALL
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    //GETONE
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    //UPDATE
    public Product updateProduct(Long id,Product product){
        Product oldProduct=productRepository.findById(id).orElse(null);
        if(oldProduct!=null){
            oldProduct.setName(product.getName());
            oldProduct.setDescription(product.getDescription());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setStock(product.getStock());
            oldProduct.setCategory(product.getCategory());
            return productRepository.save(oldProduct);
        }
        return null;
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
