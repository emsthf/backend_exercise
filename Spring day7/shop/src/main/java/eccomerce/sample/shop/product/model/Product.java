package eccomerce.sample.shop.product.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    private int price;
    private int sale;

    @Builder
    public Product(String productName, String description, int price, int sale) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.sale = sale;
    }
}
