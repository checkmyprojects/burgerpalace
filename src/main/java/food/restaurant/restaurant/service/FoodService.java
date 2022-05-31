package food.restaurant.restaurant.service;

import food.restaurant.restaurant.exception.FoodNotFoundException;
import food.restaurant.restaurant.model.Food;
import food.restaurant.restaurant.repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodService {


    private final FoodRepo foodRepo;

    @Autowired
    public FoodService(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }


    public Food addFood(Food food){
        return foodRepo.save(food);
    }

    public List<Food> findAllFoods(){
        return foodRepo.findAll();
    }

    public Food updateFood(Food food){
        return foodRepo.save(food);
    }

    public Food findFoodById(Long id){
        return foodRepo.findFoodById(id).orElseThrow(() -> new FoodNotFoundException("Food by id " + id + " was not found"));
    }

    public void deleteFood(Long id){
        foodRepo.deleteFoodById(id);
    }


}
