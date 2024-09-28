package com.safiribytes.shoppingmicroservice.order_service.service;

import com.safiribytes.shoppingmicroservice.order_service.dto.OrderRequest;
import com.safiribytes.shoppingmicroservice.order_service.model.Order;
import com.safiribytes.shoppingmicroservice.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeholder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);
    }
}
