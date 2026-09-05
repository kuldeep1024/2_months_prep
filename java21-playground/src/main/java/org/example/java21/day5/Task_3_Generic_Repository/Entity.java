package org.example.java21.day5.Task_3_Generic_Repository;

public interface Entity {
    Long id();
}

record User(Long id, String name) implements Entity {}

record Order(Long id, String orderNumber) implements Entity {}