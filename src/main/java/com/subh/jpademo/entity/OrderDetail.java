package com.subh.jpademo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

@IdClass(OrderIdEmailPk.class)
public class OrderDetail {

    @Id
    private int orderId;
    @Id
    private String email;
    private String productName;
    private double price;

}
