package com.union.JPA.exercise.service;

import com.union.JPA.exercise.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);
    Optional<Product> getProduct(int id);
    void delProduct(int id);
    List<Product> getAllProduct();
}
