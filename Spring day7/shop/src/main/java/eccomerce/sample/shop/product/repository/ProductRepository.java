package eccomerce.sample.shop.product.repository;

import eccomerce.sample.shop.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
