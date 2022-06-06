package food.restaurant.restaurant.service;

import food.restaurant.restaurant.exception.UserNotFoundException;
import food.restaurant.restaurant.model.User;
import food.restaurant.restaurant.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class UserService {

    private final UserRepo userRepo;

    @Lazy
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User addUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }

    public User findUserByEmail(String email){
        return userRepo.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User with " + email + " email was not found"));
    }
}
