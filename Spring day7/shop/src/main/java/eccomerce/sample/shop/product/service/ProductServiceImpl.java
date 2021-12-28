package eccomerce.sample.shop.product.service;

import eccomerce.sample.shop.product.model.Product;
import eccomerce.sample.shop.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return Optional.ofNullable(productRepository.findById(id).get());
    }

    @Override
    public void delProduct(Long id) {
        productRepository.deleteById(id);
    }
}
