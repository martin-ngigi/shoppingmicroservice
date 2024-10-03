package com.safiribytes.shoppingmicroservice.order_service.service;

import com.safiribytes.shoppingmicroservice.order_service.client.InventoryClient;
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
    private final InventoryClient inventoryClient;

    public void placeholder(OrderRequest orderRequest){

       var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

       if (isProductInStock){
           Order order = new Order();
           order.setOderNumber(UUID.randomUUID().toString());
           order.setPrice(orderRequest.price());
           order.setSkuCode(orderRequest.skuCode());
           order.setQuantity(orderRequest.quantity());

           orderRepository.save(order);
       }
       else {
           throw new RuntimeException("DEBUG: Product with skuCode "+orderRequest.skuCode()+ " and quantity "+  orderRequest.quantity() + " is not in stock.");
       }

    }
}
