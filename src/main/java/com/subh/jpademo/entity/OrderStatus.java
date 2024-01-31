package com.subh.jpademo.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class OrderStatus {

    @EmbeddedId
    private OrderStatusPK orderStatusPK;
    private BigDecimal price;
    private String city;
}
