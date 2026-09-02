package org.example.java21.day2.task_3_BuildResult;

public record Success<T>(T value) implements Result<T> {
}