package eccomerce.sample.shop.cart.model;

import eccomerce.sample.shop.product.model.Product;
import eccomerce.sample.shop.user.model.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    @Builder
    public Cart(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
