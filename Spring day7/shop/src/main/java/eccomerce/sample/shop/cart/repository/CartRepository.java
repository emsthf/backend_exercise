package eccomerce.sample.shop.cart.repository;

import eccomerce.sample.shop.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
