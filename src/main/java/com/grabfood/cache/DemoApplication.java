package com.grabfood.cache;

import com.grabfood.cache.service.FoodService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(FoodService foodService) {
        return args -> {
            System.out.println("Fetching food 1 first time:");
            System.out.println(foodService.getFoodList(1L));
            
            System.out.println("Fetching food 1 second time (should hit cache):");
            System.out.println(foodService.getFoodList(1L));
            
            System.out.println("Fetching food 2 first time:");
            System.out.println(foodService.getFoodList(2L));
        };
    }
}
