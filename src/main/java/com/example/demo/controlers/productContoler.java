package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductService;
import com.example.demo.model.product;

@RestController
@RequestMapping("/products") 
public class productContoler {
    @Autowired
    private ProductService productService; 
      
    @GetMapping("") 
    public List<product> getAllProducts() { 
        return productService.getAllProducts(); 
    }

    @GetMapping("/{id}") 
    public product getProductById(@PathVariable Long id) { 
        return productService.getProductById(id); 
    } 
      
    @PostMapping("/add") 
    public product createProduct(@RequestBody product p1) { 
        //return p1;
        return productService.createProduct(p1); 
    } 
      
    @PutMapping("/{id}") 
    public product updateProduct(@PathVariable Long id, @RequestBody product p1) { 
        return productService.updateProduct(id, p1); 
    } 
      
    @DeleteMapping("/{id}") 
    public void deleteProduct(@PathVariable Long id) { 
        productService.deleteProduct(id); 
    } 
}
