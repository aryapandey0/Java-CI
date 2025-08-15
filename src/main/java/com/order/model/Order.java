package com.order.model;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String productName;
    private double price;
    private int userId;
    // getters & setters
}
