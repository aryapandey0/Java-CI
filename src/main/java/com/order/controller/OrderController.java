package com.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.client.UserClient;
import com.order.model.*;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final UserClient userClient;
    private List<Order> orders = new ArrayList<>();

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        orders.add(order);
        return order;
    }

    @GetMapping("/details/{orderId}")
    public Map<String, Object> getOrderDetails(@PathVariable int orderId) {
        // Apne order ka data nikal
        Order order = orders.stream()
                .filter(o -> o.getId() == orderId)
                .findFirst()
                .orElse(null);

        if (order == null) {
            return Map.of("error", "Order not found");
        }

        // User ka data UserService se le
        User user = userClient.getUserById(order.getUserId());

        // Combine data
        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("user", user);

        return response;
    }
}
