package org.example.java21.day2.task_3_BuildResult.after;

import org.example.java21.day2.task_3_BuildResult.*;
import org.example.java21.day2.task_3_BuildResult.repo.UserRepository;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Result<User> findUser(String id) {

        User user = repository.find(id);

        if (user == null) {
            return new Failure<>("User not found: " + id);
        }

        return new Success<>(user);
    }
}