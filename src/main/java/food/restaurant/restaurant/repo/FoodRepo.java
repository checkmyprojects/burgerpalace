package food.restaurant.restaurant.repo;

import food.restaurant.restaurant.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {

    void deleteFoodById(Long id);

    Optional<Food> findFoodById(Long id);
}
