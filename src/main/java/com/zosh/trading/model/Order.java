package com.zosh.trading.model;


import com.zosh.trading.domain.OrderStatus;
import com.zosh.trading.domain.OrderType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  Long Id;

    @ManyToOne
    private  User user;

    @Column( nullable = false)// meaning without this field order will not create
    private OrderType orderType;

    @Column( nullable = false)
    private BigDecimal price;

    private LocalDateTime timestamp = LocalDateTime.now();

    @Column( nullable = false)
    private OrderStatus status;


    @OneToOne(mappedBy = "order", cascade =  CascadeType.ALL) // means updation continious

    private OrderItem orderItem;



}
