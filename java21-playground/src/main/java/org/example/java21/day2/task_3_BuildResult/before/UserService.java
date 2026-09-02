package org.example.java21.day2.task_3_BuildResult.before;

import org.example.java21.day2.task_3_BuildResult.User;
import org.example.java21.day2.task_3_BuildResult.UserNotFoundException;
import org.example.java21.day2.task_3_BuildResult.repo.UserRepository;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findUser(String id) throws UserNotFoundException {

        User user = repository.find(id);

        if (user == null) {
            throw new UserNotFoundException("User not found: " + id);
        }

        return user;
    }
}