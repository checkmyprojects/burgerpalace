package food.restaurant.restaurant.service;

import food.restaurant.restaurant.model.Orders;
import food.restaurant.restaurant.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepo ordersRepo;

    @Autowired
    public OrdersService(OrdersRepo ordersRepo){
        this.ordersRepo = ordersRepo;
    }
    public Orders addOrder(Orders order){
        return ordersRepo.save(order);
    }

    public List<Orders> findAllOrders(){
        return ordersRepo.findAll();
    }
}
