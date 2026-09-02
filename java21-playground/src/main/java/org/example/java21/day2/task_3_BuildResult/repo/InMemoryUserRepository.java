package org.example.java21.day2.task_3_BuildResult.repo;

import org.example.java21.day2.task_3_BuildResult.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public InMemoryUserRepository() {
        users.put("1", new User("1", "Kuldeep", "kuldeep@example.com"));
        users.put("2", new User("2", "Anish", "anish@example.com"));
    }

    @Override
    public User find(String id) {
        return users.get(id);
    }
}