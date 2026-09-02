package org.example.java21.day2.task_2_OrderRefactoring.after;

public sealed interface OrderStatus
        permits Pending, Confirmed, Shipped, Cancelled {
}