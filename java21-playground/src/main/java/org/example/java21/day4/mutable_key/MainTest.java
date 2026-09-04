package org.example.java21.day4.mutable_key;

import java.util.HashSet;
import java.util.Set;

public class MainTest {
    static void main(String[] args) {
        User user = new User("a@test.com","kuldeep");

        Set<User> set = new HashSet<>();
        set.add(user);

        System.out.println(set.contains(user));

        user.email = "b@test.com";

        System.out.println(set.contains(user));

    }
}
