package com.kelvin.springbootcrudexample.service;

import com.kelvin.springbootcrudexample.entity.Product;
import com.kelvin.springbootcrudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //post method
    //post single product
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    //post multiple products
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    //get method
    //getting multiple products by id
    public List<Product> getProducts() {
        return repository.findAll();
    }
    //getting single product by id
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    //getting product by name
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    //delete method
     public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product deleted !! " +id;
    }

    //updating Method
    public Product updateProduct(Product product) {
        Product existingProduct=repository.findById(product.getId()).orElse(null);
                existingProduct.setName(product.getName());
                existingProduct.setQuantity(product.getQuantity());
                existingProduct.setPrice(product.getPrice());

                return repository.save(existingProduct);
    }
}
