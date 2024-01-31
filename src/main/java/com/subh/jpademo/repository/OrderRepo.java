package com.subh.jpademo.repository;

import com.subh.jpademo.entity.OrderDetail;
import com.subh.jpademo.entity.OrderIdEmailPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetail, OrderIdEmailPk> {
}
