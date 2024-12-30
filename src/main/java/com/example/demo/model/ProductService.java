package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository; 
      
    public List<product> getAllProducts() { 
        return productRepository.findAll(); 
    } 

    public product getProductById(Long id) { 
        return productRepository.findById(id).orElse(null); 
    } 
      
    public product createProduct(product p1) { 
        return productRepository.save(p1); 
    } 
      
    public product updateProduct(Long id, product newProduct) { 
        product p1 = productRepository.findById(id).orElse(null); 
        if (p1 != null) { 
            p1.setPname(newProduct.getPname());
            p1.setPrice(newProduct.getPrice());
           
            return productRepository.save(newProduct); 
        } else { 
            return null; 
        } 
    } 
      
    public void deleteProduct(Long id) { 
        productRepository.deleteById(id); 
    }
    
}
