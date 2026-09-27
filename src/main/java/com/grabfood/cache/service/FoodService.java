package com.grabfood.cache.service;

import com.grabfood.cache.model.Food;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FoodService {

    @Cacheable(value = "foodList", key = "#restaurantId")
    public List<Food> getFoodList(Long restaurantId) {
        System.out.println("Fetching from database for restaurantId: " + restaurantId);
        // Simulate a slow database call
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if (restaurantId == 1L) {
            return Arrays.asList(
                    new Food(1L, "Pho", 50000.0),
                    new Food(2L, "Bun Cha", 45000.0)
            );
        } else {
            return Arrays.asList(
                    new Food(3L, "Banh Mi", 20000.0)
            );
        }
    }
}
