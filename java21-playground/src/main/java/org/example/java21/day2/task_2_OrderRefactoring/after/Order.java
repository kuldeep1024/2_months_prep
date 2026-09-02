package org.example.java21.day2.task_2_OrderRefactoring.after;

import java.time.LocalDateTime;
import java.util.List;

public record Order(
        String orderId,
        String customerId,
        List<String> productIds,
        double totalAmount,
        String currency,
        OrderStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public Order {

        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException(
                    "Order ID cannot be null or blank");
        }

        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer ID cannot be null or blank");
        }

        if (productIds == null || productIds.isEmpty()) {
            throw new IllegalArgumentException(
                    "Order must contain at least one product");
        }

        for (String productId : productIds) {
            if (productId == null || productId.isBlank()) {
                throw new IllegalArgumentException(
                        "Product ID cannot be null or blank");
            }
        }

        if (totalAmount < 0) {
            throw new IllegalArgumentException(
                    "Total amount cannot be negative");
        }

        if (currency == null || currency.length() != 3) {
            throw new IllegalArgumentException(
                    "Currency must contain 3 characters");
        }

        if (status == null) {
            throw new IllegalArgumentException(
                    "Status cannot be null");
        }

        if (createdAt == null || updatedAt == null) {
            throw new IllegalArgumentException(
                    "Date cannot be null");
        }

        if (updatedAt.isBefore(createdAt)) {
            throw new IllegalArgumentException(
                    "Updated time cannot be before created time");
        }

        productIds = List.copyOf(productIds);
    }
}