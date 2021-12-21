package hellojpa;

import javax.persistence.*;

@Entity
//@Table(name = "ITEM")   // 사실 이렇게 테이블 명을 바꾸는 것은 아주 좋지 않다
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 대규모 테이블에는 보통 Long 클래스를 써서 프라이머리 키를 잡음

    @Column(name="name")   // 리액트에서 체험해 봤듯이 컬럼의 이름이 같아야 복잡한 작업을 안해도 되는 경우가 많다
    private String productName;   // 그래서 백엔드에서는 productName으로 사용하지만 DB 상에는 name으로 들어가도록 했음

    private Integer age;   // int보다 Integer 클래스를 사용??
    private String description;
    private Integer price;
    private Integer sale;
    private Integer inventory;

    public Product() {
    }

    public Product(String productName, Integer age, String description, Integer price, Integer sale, Integer inventory) {
        this.productName = productName;
        this.age = age;
        this.description = description;
        this.price = price;
        this.sale = sale;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
