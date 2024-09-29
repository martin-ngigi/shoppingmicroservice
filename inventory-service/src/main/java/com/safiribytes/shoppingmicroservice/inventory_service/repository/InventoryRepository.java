package com.safiribytes.shoppingmicroservice.inventory_service.repository;

import com.safiribytes.shoppingmicroservice.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    /// Query will be automatically be created.
    Boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
