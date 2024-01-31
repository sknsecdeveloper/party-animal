package com.subh.jpademo.controller;

import com.subh.jpademo.entity.OrderDetail;
import com.subh.jpademo.entity.OrderIdEmailPk;
import com.subh.jpademo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @PostMapping("/order")
    public OrderDetail saveOrder(@RequestBody OrderDetail order) {
        return orderRepo.save(order);
    }

    @GetMapping("/order/{orderId}/{email}")
    public OrderDetail getOrderById(@PathVariable int orderId, @PathVariable String email) {

        OrderIdEmailPk orderIdEmailPk = new OrderIdEmailPk(orderId,email);
        return orderRepo.findById(orderIdEmailPk).get();
    }
}
