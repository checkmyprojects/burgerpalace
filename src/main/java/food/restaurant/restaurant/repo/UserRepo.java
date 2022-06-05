package food.restaurant.restaurant.repo;

import food.restaurant.restaurant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);

    Optional<User>  findUserByEmail(String email);
}
