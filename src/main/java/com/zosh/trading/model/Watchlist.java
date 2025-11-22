package com.zosh.trading.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;


    @OneToOne
    private User user;


    @ManyToMany
    @ElementCollection
    private List<Coin> coins = new ArrayList<>();



}
