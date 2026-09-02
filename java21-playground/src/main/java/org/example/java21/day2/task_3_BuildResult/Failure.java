package org.example.java21.day2.task_3_BuildResult;

public record Failure<T>(String error) implements Result<T> {
}