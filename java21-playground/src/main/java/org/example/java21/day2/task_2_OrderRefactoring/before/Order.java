package org.example.java21.day2.task_2_OrderRefactoring.before;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private String orderId;
    private String customerId;
    private List<String> productIds;
    private double totalAmount;
    private String currency;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(String orderId, String customerId, List<String> productIds, double totalAmount, String currency, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {

        validateOrderId(orderId);
        validateCustomerId(customerId);
        validateProductIds(productIds);
        validateAmount(totalAmount);
        validateCurrency(currency);
        validateStatus(status);
        validateCreatedAt(createdAt);
        validateUpdatedAt(updatedAt);

        this.orderId = orderId;
        this.customerId = customerId;
        this.productIds = new ArrayList<>(productIds);
        this.totalAmount = totalAmount;
        this.currency = currency;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private void validateOrderId(String orderId) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID cannot be null or blank");
        }
    }

    private void validateCustomerId(String customerId) {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID cannot be null or blank");
        }
    }

    private void validateProductIds(List<String> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one product");
        }

        for (String productId : productIds) {
            if (productId == null || productId.isBlank()) {
                throw new IllegalArgumentException("Product ID cannot be null or blank");
            }
        }
    }

    private void validateAmount(double totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount cannot be negative");
        }
    }

    private void validateCurrency(String currency) {
        if (currency == null || currency.length() != 3) {
            throw new IllegalArgumentException("Currency must contain 3 characters");
        }
    }

    private void validateStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status cannot be null or blank");
        }
    }

    private void validateCreatedAt(LocalDateTime createdAt) {
        if (createdAt == null) {
            throw new IllegalArgumentException("Created time cannot be null");
        }
    }

    private void validateUpdatedAt(LocalDateTime updatedAt) {
        if (updatedAt == null) {
            throw new IllegalArgumentException("Updated time cannot be null");
        }

        if (updatedAt.isBefore(createdAt)) {
            throw new IllegalArgumentException("Updated time cannot be before created time");
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        validateOrderId(orderId);
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        validateCustomerId(customerId);
        this.customerId = customerId;
    }

    public List<String> getProductIds() {
        return new ArrayList<>(productIds);
    }

    public void setProductIds(List<String> productIds) {
        validateProductIds(productIds);
        this.productIds = new ArrayList<>(productIds);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        validateAmount(totalAmount);
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        validateCurrency(currency);
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        validateStatus(status);
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        validateCreatedAt(createdAt);
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        validateUpdatedAt(updatedAt);
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Order)) {
            return false;
        }

        Order order = (Order) o;

        return Double.compare(order.totalAmount, totalAmount) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(customerId, order.customerId) && Objects.equals(productIds, order.productIds) && Objects.equals(currency, order.currency) && Objects.equals(status, order.status) && Objects.equals(createdAt, order.createdAt) && Objects.equals(updatedAt, order.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, productIds, totalAmount, currency, status, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId='" + orderId + '\'' + ", customerId='" + customerId + '\'' + ", productIds=" + productIds + ", totalAmount=" + totalAmount + ", currency='" + currency + '\'' + ", status='" + status + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}