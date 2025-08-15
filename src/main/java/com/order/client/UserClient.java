package com.order.client;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:8081")
public interface UserClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable int id);
}

