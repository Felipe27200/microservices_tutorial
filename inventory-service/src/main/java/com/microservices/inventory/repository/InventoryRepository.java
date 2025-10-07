package com.microservices.inventory.repository;

import com.microservices.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long>
{
    /*
    * It'll return a record that matches with the sku_code and whose quantity
    * is greater than or equal to the given quantity
    * */
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
