package com.subh.jpademo.repository;

import com.subh.jpademo.entity.OrderStatus;
import com.subh.jpademo.entity.OrderStatusPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepo extends JpaRepository<OrderStatus, OrderStatusPK> {
}
