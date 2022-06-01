package food.restaurant.restaurant.repo;

import food.restaurant.restaurant.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
}
