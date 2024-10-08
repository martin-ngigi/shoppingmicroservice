package com.safiribytes.shoppingmicroservice.inventory_service.controller;

import com.safiribytes.shoppingmicroservice.inventory_service.Service.InventoryService;
import com.safiribytes.shoppingmicroservice.inventory_service.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return inventoryService.isInStore(skuCode, quantity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/all/products")
    public List<Inventory> getAllProducts(){
        return inventoryService.getAllProducts();
    }
}
