package com.safiribytes.shoppingmicroservice.order_service.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/// Communication between two services. i.e. between order-service and inventory-service
public interface InventoryClient {

    /// Its implementation is in config/RestClientConfig
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
