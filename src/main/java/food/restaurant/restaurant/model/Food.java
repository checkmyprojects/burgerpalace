package food.restaurant.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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

    // prep time
    // time to the client

    // numero de pedido -> varios platos

    // 1 numero de pedido onetomany platos (varios)
    // 1 cliente onetomany num_pedido (varios)
    // varias comidas

    public Food() {
    }

    public Food(String name, String type, String ingredients, boolean vegan, String alergies, double price) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.vegan = vegan;
        this.alergies = alergies;
        this.price = price;
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
                '}';
    }
}
