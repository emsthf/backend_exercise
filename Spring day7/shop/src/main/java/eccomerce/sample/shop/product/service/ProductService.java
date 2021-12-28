package eccomerce.sample.shop.product.service;

import eccomerce.sample.shop.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProduct();
    Optional<Product> getProduct(Long id);
    void delProduct(Long id);
}
