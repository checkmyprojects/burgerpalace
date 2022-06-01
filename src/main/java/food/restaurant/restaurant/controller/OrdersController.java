package food.restaurant.restaurant.controller;

import food.restaurant.restaurant.model.Orders;
import food.restaurant.restaurant.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/all")
    public List<Orders> ordersList(){
        return ordersService.findAllOrders();
    }
}
