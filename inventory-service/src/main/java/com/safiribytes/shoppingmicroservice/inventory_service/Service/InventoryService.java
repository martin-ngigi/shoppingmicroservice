package com.safiribytes.shoppingmicroservice.inventory_service.Service;

import com.safiribytes.shoppingmicroservice.inventory_service.model.Inventory;
import com.safiribytes.shoppingmicroservice.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStore(String skuCode, Integer quantity){
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

    // Method to get all products
    public List<Inventory> getAllProducts() {
        return inventoryRepository.findAll();
    }

}
