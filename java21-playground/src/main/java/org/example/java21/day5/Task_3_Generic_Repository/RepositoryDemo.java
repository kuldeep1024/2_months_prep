package org.example.java21.day5.Task_3_Generic_Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryDemo {

    public static void main(String[] args) {
        // --- 1. Testing User Repository ---
        Repository<User> userRepository = new Repository<>();
        
        userRepository.add(new User(1L, "Alice"));

        List<User> userBatch = List.of(
            new User(2L, "Bob"),
            new User(3L, "Charlie")
        );
        userRepository.addAll(userBatch); // addAll using Collection<? extends User>

        List<Object> userDestination = new ArrayList<>();
        userRepository.copyTo(userDestination); // copyTo using Collection<? super User>

        System.out.println("User Repository size: " + userRepository.getAll().size());
        System.out.println("User destination contents (Collection<Object>): " + userDestination);

        System.out.println("--------------------------------------------------");

        // --- 2. Testing Order Repository ---
        Repository<Order> orderRepository = new Repository<>();

        orderRepository.add(new Order(101L, "ORD-2026-001"));

        List<Order> orderBatch = List.of(
            new Order(102L, "ORD-2026-002"),
            new Order(103L, "ORD-2026-003")
        );
        orderRepository.addAll(orderBatch);

        List<Entity> entityDestination = new ArrayList<>();
        orderRepository.copyTo(entityDestination); // copyTo into Collection<Entity>

        System.out.println("Order Repository size: " + orderRepository.getAll().size());
        System.out.println("Entity destination contents (Collection<Entity>): " + entityDestination);
    }
}