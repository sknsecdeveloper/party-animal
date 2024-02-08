package com.subh.jpademo.repository;

import com.subh.jpademo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderNewRepo extends JpaRepository<Order, Integer> {
}
