package org.example.java21.day2.task_3_BuildResult.repo;

import org.example.java21.day2.task_3_BuildResult.User;

public interface UserRepository {
    User find(String id);
}