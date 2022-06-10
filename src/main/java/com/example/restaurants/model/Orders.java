package com.example.restaurants.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private long restaurantId;

    @Column(nullable = false)
    private long foodId;

    @Column(nullable = false)
    private int orderQuantity;

    @Column(nullable = false)
    private int orderPrice;

}
