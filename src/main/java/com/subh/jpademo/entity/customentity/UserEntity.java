package com.subh.jpademo.entity.customentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class UserEntity {

    @Id
    private int id;
    @OneToOne
    private UserEntity manager;
}
