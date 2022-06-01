package food.restaurant.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="food")
public class Food implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String type;
    private String ingredients;
    private boolean vegan;
    private String alergies;
    private double price;

    @ManyToMany (mappedBy = "food")
    private Set<Orders> order;

    // prep time
    // time to the client

    // numero de pedido -> varios platos

    // 1 numero de pedido onetomany platos (varios)
    // 1 cliente onetomany num_pedido (varios)
    // varias comidas

    public Food() {
    }

    public Food(String name, String type, String ingredients, boolean vegan, String alergies, double price, Set<Orders> order) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.vegan = vegan;
        this.alergies = alergies;
        this.price = price;
        this.order = order;
    }

    public Set<Orders> getOrder() {
        return order;
    }

    public void setOrder(Set<Orders> order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", vegan=" + vegan +
                ", alergies='" + alergies + '\'' +
                ", price=" + price +
                ", order=" + order +
                '}';
    }
}
