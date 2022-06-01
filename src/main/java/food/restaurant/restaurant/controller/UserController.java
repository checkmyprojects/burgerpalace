package food.restaurant.restaurant.controller;

import food.restaurant.restaurant.model.User;
import food.restaurant.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/edit/all")
    public List<User> listUser(){
        return userService.findAllUsers();
    }

    @GetMapping("/edit/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }

    @PutMapping("/edit/")
    public User editUserById(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/edit/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
