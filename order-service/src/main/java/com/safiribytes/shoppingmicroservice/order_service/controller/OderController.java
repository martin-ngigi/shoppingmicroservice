package com.safiribytes.shoppingmicroservice.order_service.controller;

import com.safiribytes.shoppingmicroservice.order_service.dto.OrderRequest;
import com.safiribytes.shoppingmicroservice.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeholder(orderRequest);
        return "Order placed successfully.";
    }
}
