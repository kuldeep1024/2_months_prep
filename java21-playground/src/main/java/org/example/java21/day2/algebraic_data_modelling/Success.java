package org.example.java21.day2.algebraic_data_modelling;

public record Success<T>(T value)
        implements Result<T> {
}