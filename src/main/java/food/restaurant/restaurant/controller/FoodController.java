package food.restaurant.restaurant.controller;

import food.restaurant.restaurant.model.Food;
import food.restaurant.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/all")
    public List<Food> listFood(){
        return foodService.findAllFoods();
    }

    @GetMapping("/{id}")
    public Food findFoodById(@PathVariable("id") Long id){
        return foodService.findFoodById(id);
    }

    @PutMapping("/edit/")
    public Food editFoodById(@RequestBody Food food){
        System.out.println("updating " + food);
        return foodService.addFood(food);
    }

    @DeleteMapping("/edit/delete/{id}")
    public void deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
    }

    @PostMapping("/edit/add")
    public Food addFood(@RequestBody Food food){
        return foodService.addFood(food);
    }


    /* @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody Food food){
        Food newFood = foodService.addFood(food);
        return new ResponseEntity<>(newFood, HttpStatus.CREATED);
    }*/

}
