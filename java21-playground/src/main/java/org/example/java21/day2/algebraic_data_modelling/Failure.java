package org.example.java21.day2.algebraic_data_modelling;

public record Failure<T>(String error)
        implements Result<T> {
}