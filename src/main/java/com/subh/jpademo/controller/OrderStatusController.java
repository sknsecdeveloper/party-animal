package com.subh.jpademo.controller;

import com.subh.jpademo.entity.OrderStatus;
import com.subh.jpademo.entity.OrderStatusPK;
import com.subh.jpademo.repository.OrderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderStatusController {

    @Autowired
    private OrderStatusRepo orderStatusRepo;

    @PostMapping("/orderStatus")
    public OrderStatus saveOrderStatus(@RequestBody OrderStatus orderStatus) {
        return orderStatusRepo.save(orderStatus);
    }

    @GetMapping("/orderStatus/{id}/{productName}")
    public OrderStatus getOrderStatusById(@PathVariable int id, @PathVariable String productName) {
        return orderStatusRepo.findById(new OrderStatusPK(id, productName)).get();
    }
}
