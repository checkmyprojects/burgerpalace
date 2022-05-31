package food.restaurant.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String password;
    private String role = "ROLE_USER";

}
